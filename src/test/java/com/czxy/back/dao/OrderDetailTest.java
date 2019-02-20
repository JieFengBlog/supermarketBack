package com.czxy.back.dao;

import com.czxy.back.BaseTest;
import com.czxy.back.bean.OrderDetail;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderDetailTest extends BaseTest {


    @Autowired
    private OrderDetailDao orderDetailDao;


    /**
     *
     */
    @Test
    public void testgetOrderDetail(){
        List<OrderDetail> list = orderDetailDao.getOrderDetail(1);
        System.out.println(list);
    }
}