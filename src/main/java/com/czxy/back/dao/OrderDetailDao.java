package com.czxy.back.dao;

import com.czxy.back.bean.OrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDetailDao {

    /**
     * 批量插入订单包含的商品详情
     * @return
     */
    boolean batchInsertOrderDetail( @Param("orderDetailList") List<OrderDetail> list);

    /**
     * 根据传过来的订单id去查询对应的订单详情给列表
     * @param orderId
     * @return
     */
    List<OrderDetail> getOrderDetail(Integer orderId);

    /**
     * 批量删除商品详情
     * @param orderId
     * @return
     */
    int batchDeleteOrder(Integer orderId);

}
