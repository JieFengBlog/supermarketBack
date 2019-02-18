package com.czxy.back.dao;

import com.czxy.back.BaseTest;
import com.czxy.back.bean.Order;
import org.aspectj.weaver.ast.Or;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderTest extends BaseTest {

    @Autowired
    private OrderDao orderDao;

    @Test
    public void testGetOrderById(){
        Order order = orderDao.getOrderById(1);
        System.out.println(order);

    }

    @Test
    public void testGetAllOrder(){
        System.out.println();
        List<Order> listIn = orderDao.getAllOrder(0);

        List<Order> listOut = orderDao.getAllOrder(1);
//        System.out.println("----------------------");
//        System.out.println(orderDao.getAllOrder(null));
        System.out.println("-----------0----------------");
        System.out.println(listIn);
//        System.out.println("-----------1--------------");
//        System.out.println(listOut);
    }
}