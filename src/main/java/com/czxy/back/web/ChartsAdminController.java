package com.czxy.back.web;


import com.czxy.back.service.EmployeeService;
import com.czxy.back.service.OrderService;
import com.czxy.back.service.ProductService;
import com.czxy.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/charts")
public class ChartsAdminController {

    @Autowired
    private ProductService productService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping(value = "/count",method = RequestMethod.GET)
    private Map<String,Object> countCharts(){
        Map<String,Object> modelMap = new HashMap<>();
        try{
            int productCount = productService.countProduct();
            int employeeCount = employeeService.countEmployee();
            int userCount = userService.countUser();
            modelMap.put("user",userCount);
            modelMap.put("employee",employeeCount);
            modelMap.put("product",productCount);
            modelMap.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
        }
        return modelMap;
    }

    @RequestMapping(value = "/orderperday",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getOrderPerDay(){
        Map<String,Object> modelMap = new HashMap<>();
        List<Map<String,Object>> dayList = new ArrayList<>();

        Map<String,Object> everyDay0 = new HashMap<>();//今天
        Map<String,Object> everyDay1 = new HashMap<>();//昨天
        Map<String,Object> everyDay2 = new HashMap<>();//前天

        everyDay2.put("日期","前天");
        everyDay2.put("进货订单",orderService.everyDayOrderCount(0,2));
        everyDay2.put("出货订单",orderService.everyDayOrderCount(1,2));

        everyDay1.put("日期","昨天");
        everyDay1.put("进货订单",orderService.everyDayOrderCount(0,1));
        everyDay1.put("出货订单",orderService.everyDayOrderCount(1,1));

        everyDay0.put("日期","今天");
        everyDay0.put("进货订单",orderService.everyDayOrderCount(0,0));
        everyDay0.put("出货订单",orderService.everyDayOrderCount(1,0));


        dayList.add(everyDay2);
        dayList.add(everyDay1);
        dayList.add(everyDay0);

        modelMap.put("dayCount",dayList);
        return  modelMap;
    }


    @RequestMapping(value = "/userperday",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getUserPerDay() {
        Map<String, Object> modelMap = new HashMap<>();
        List<Map<String, Object>> userList = new ArrayList<>();

        Map<String, Object> day0 = new HashMap<>();//今天
        System.out.println();
        Map<String, Object> day1 = new HashMap<>();//昨天
        Map<String, Object> day2 = new HashMap<>();//前天

        day0.put("日期","今天");
        day0.put("注册数",userService.everyDayUserCount(0));
        day1.put("日期","昨天");
        day1.put("注册数",userService.everyDayUserCount(1));
        day2.put("日期","前天");
        day2.put("注册数",userService.everyDayUserCount(2));

        userList.add(day2);
        userList.add(day1);
        userList.add(day0);

        modelMap.put("userDayCount",userList);

        return  modelMap;

    }


    @RequestMapping(value = "/getordercount",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getOrderCount() {
        Map<String, Object> modelMap = new HashMap<>();
        List<Map<String, Object>> orderList = new ArrayList<>();

        Map<String, Object> inOrder = new HashMap<>();//进货订单
        Map<String, Object> outOrder = new HashMap<>();//出货订单


        inOrder.put("订单类型","入库订单");
        inOrder.put("订单数",orderService.countOrder(0));
        outOrder.put("订单类型","出库订单");
        outOrder.put("订单数",orderService.countOrder(1));

        orderList.add(inOrder);
        orderList.add(outOrder);

        modelMap.put("orderList",orderList);

        return modelMap;

    }
}
