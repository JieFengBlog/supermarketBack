package com.czxy.back.dao;


import com.czxy.back.bean.Order;

import java.util.List;

public interface OrderDao {

    /**
     * 根据id获取订单
     * @param id
     * @return
     */
    Order getOrderById(Integer id);

    /**
     * 获取所有的订单
     * 0 进货订单 1 出货订单 3全部订单
     * @return
     */
    List<Order> getAllOrder(Integer orderType);

    /**
     * 插入订单
     * @param order
     * @return
     */
    boolean insertOrder(Order order);

    /**
     * 更新订单
     * @param order
     * @return
     */
    boolean updateOrder(Order order);

    /**
     * 根据id删除订单
     * @param id
     * @return
     */
    boolean deleteOrder(Integer id);


}
