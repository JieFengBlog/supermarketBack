package com.czxy.back.service.impl;

import com.czxy.back.bean.Order;
import com.czxy.back.bean.OrderDetail;
import com.czxy.back.dao.OrderDetailDao;
import com.czxy.back.dao.ProductDao;
import com.czxy.back.service.OrderDetailService;
import exceptions.OrderDetailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private ProductDao productDao;

    /**
     * 批量添加订单中的详情商品
     * @param detailList
     * @return
     * @throws OrderDetailException
     */
    @Override
    @Transactional
    public boolean batchInsertOrderDetail(List<OrderDetail> detailList,boolean orderType) throws OrderDetailException {
        boolean result1 = false;
        try{
            if(orderType){
                //更新库存
               result1 = productDao.updateStockIn(detailList);
            }else{
                result1 = productDao.updateStockOut(detailList);
            }
            //批量插入订单详情商品
            boolean result2 = orderDetailDao.batchInsertOrderDetail(detailList);
            if(result1 && result2){
                return true;
            }
        }catch(Exception e){
            throw new OrderDetailException("OrderDetailServiceImpl中有异常");
        }
        return false;
    }

    /**
     *
     * @param orderId
     * @return
     */
    @Override
    public List<OrderDetail> getOrderDetailList(Integer orderId) {

        List<OrderDetail> list = orderDetailDao.getOrderDetail(orderId);
        return list;
    }
}
