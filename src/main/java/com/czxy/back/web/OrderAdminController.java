package com.czxy.back.web;


import com.czxy.back.bean.Order;
import com.czxy.back.bean.OrderDetail;
import com.czxy.back.bean.User;
import com.czxy.back.dao.OrderDao;
import com.czxy.back.service.OrderDetailService;
import com.czxy.back.service.OrderService;
import com.czxy.back.util.DateUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/order")
@ResponseBody
public class OrderAdminController {


    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderService orderService;

    /**
     * 生成订单
     * @param map
     * @return
     */
    @RequestMapping(value = "/purchase", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> purchase(@RequestBody Map map) {

        Map<String,Object> modelMap = new HashMap<>();
        boolean result1 = false;

        //生成订单
        Order order = new Order();

        //订单号
        order.setOrderNumber(DateUtil.getOrderNumber());
        order.setOrderStatus(1);
        order.setCreateTime(new Date());
        if((boolean) map.get("InOrOut")){
            order.setOrderProvide((String)map.get("supply"));
            order.setOrderType(0);
        }else{
            User user = new User();
            user.setId((Integer)map.get("consumer"));
            order.setUser(user);
            order.setOrderType(1);
        }
        //插入订单
        boolean result = orderDao.insertOrder(order);
        System.out.println("orderId: " + order.getId());
        //统计金额
        float totalMoney = 0;
        try{
            if(result){
                //如果订单生成成功，则开始一步步生成订单详情列表
                ArrayList list = (ArrayList)map.get("product");
                List<OrderDetail> detailList = new ArrayList<>();
                for(int i = 0; i < list.size(); i++){
                    JSONObject object = JSONObject.fromObject(list.get(i));
                    System.out.println(object);
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setProductId((Integer)object.get("id"));
                    orderDetail.setOrderId(order.getId());
                    orderDetail.setProductName((String)object.get("name"));
                    orderDetail.setProductDesc((String)object.get("productDesc"));
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println(object.get("price") instanceof Integer);
                    System.out.println(object.get("price") instanceof Double);

                    orderDetail.setProductPrice(OrderAdminController.numberTransformDouble(object.get("price")) );
                    orderDetail.setProductAmount(Integer.parseInt((String)object.get("number")));

                    //统计出订单的金额总额
                    totalMoney += (OrderAdminController.numberTransformDouble(object.get("money")));
                    orderDetail.setAmountOfMoney(OrderAdminController.numberTransformDouble(object.get("money")));
                    orderDetail.setIsProductExists(1);
                    detailList.add(orderDetail);
                }
                //将统计好的金额设置到里面
                Order sumPrice = new Order();
                sumPrice.setId(order.getId());
                sumPrice.setOrderPrice(totalMoney);
                System.out.println("totalMoney: " + totalMoney);
                orderDao.updateOrder(sumPrice);
                if((boolean) map.get("InOrOut"))
                    result1 = orderDetailService.batchInsertOrderDetail(detailList,true);
                else
                    result1 = orderDetailService.batchInsertOrderDetail(detailList,false);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        if(result1){
            modelMap.put("success",true);
        }else{
            modelMap.put("success",false);
        }
        return modelMap;
    }

    @RequestMapping(value = "/getallorder", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getAllOrder(@RequestBody Map map) {
        Map<String,Object> modelMap = new HashMap<>();
        Integer status = (Integer)map.get("status");
        List<Order> orderList = orderDao.getAllOrder(status);
        if (orderList != null){
            modelMap.put("success",true);
            modelMap.put("orderList",orderList);
        }else{
            modelMap.put("success",false);
        }
        return modelMap;
    }

    @RequestMapping(value = "/updateorder", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateOrder(@RequestBody Map map) {
        Map<String,Object> modelMap = new HashMap<>();
        JSONObject object = JSONObject.fromObject(map.get("orderUpdateForm"));
        Order order = (Order)JSONObject.toBean(object,Order.class);
        System.out.println(order);
        User user = new User();
        user.setId((Integer)map.get("userId"));
        order.setUser(user);
        boolean result = orderService.updateOrder(order);
        if(result){
            modelMap.put("success",true);
        }else{
            modelMap.put("success",false);
        }
        return modelMap;
    }

    /**
     * 删除订单
     * @param map
     * @return
     */

    @RequestMapping(value = "/deleteorder", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> deleteOrder(@RequestBody Map map) {
        Map<String,Object> modelMap = new HashMap<>();
        Integer id = (Integer)map.get("id");
        boolean result = orderService.deleteOrder(id);
        if(result){
            modelMap.put("success",true);
        }else{
            modelMap.put("success",false);
        }
        return modelMap;
    }


    public static double numberTransformDouble(Object number){
        double temp = 0.0;
        if(number instanceof Integer){
            temp = (int) number;
            return temp;
        }else{
            return (double)number;
        }
    }

}
