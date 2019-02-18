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

}
