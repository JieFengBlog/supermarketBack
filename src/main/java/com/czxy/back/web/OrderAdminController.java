package com.czxy.back.web;


import com.czxy.back.bean.Order;
import com.czxy.back.bean.OrderDetail;
import com.czxy.back.dao.OrderDao;
import com.czxy.back.service.OrderDetailService;
import com.czxy.back.util.DateUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
            order.setUserId(1);
            order.setOrderType(1);
        }
        //插入订单
        boolean result = orderDao.insertOrder(order);
        System.out.println("orderId: " + order.getId());
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
                    orderDetail.setProductPrice((Integer)object.get("price"));
                    orderDetail.setProductAmount(Integer.parseInt((String)object.get("number")));
                    orderDetail.setAmountOfMoney(Integer.parseInt((String)object.get("money")));
                    orderDetail.setIsProductExists(1);
                    detailList.add(orderDetail);
                }
                result1 = orderDetailService.batchInsertOrderDetail(detailList);

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        if(result1){
            modelMap.put("success",true);
        }else{
            modelMap.put("success",true);
        }
        return modelMap;
    }
}
