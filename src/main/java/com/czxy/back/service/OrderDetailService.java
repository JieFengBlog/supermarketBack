package com.czxy.back.service;

import com.czxy.back.bean.OrderDetail;

import java.util.List;

public interface OrderDetailService {

    /**
     * 批量添加订单详情商品，而且将对应库存更新
     * @return
     */
    public boolean batchInsertOrderDetail(List<OrderDetail> detailList,boolean orderType);

    /**
     * 根据orderid查询订单的详情商品列表
     * @param orderId
     * @return
     */
    List<OrderDetail> getOrderDetailList(Integer orderId);
}
