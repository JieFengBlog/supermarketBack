package com.czxy.back.service;

import com.czxy.back.bean.Order;

import java.util.List;

public interface OrderService {


    /**
     * 更新订单数据
     * @param order
     * @return
     */

     boolean updateOrder(Order order);


     boolean deleteOrder(Integer id);
}
