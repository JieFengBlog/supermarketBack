package com.czxy.back.web;

import com.czxy.back.bean.OrderDetail;
import com.czxy.back.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/order")
@Controller
public class OrderDetailAdminController {

    @Autowired
    private OrderDetailService orderDetailService;


    @RequestMapping(value = "/getorderdetail",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> getOrderDetailByOrderId(@RequestBody Map map){
        Map<String,Object> modelMap = new HashMap<>();
        List<OrderDetail> list = orderDetailService.getOrderDetailList((Integer)map.get("orderId"));
        if(list != null){
            modelMap.put("success",true);
            modelMap.put("detailList",list);
        }else{
            modelMap.put("success",false);
        }
        return modelMap;
    }
}
