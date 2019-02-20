package com.czxy.back.service.impl;

import com.czxy.back.bean.Order;
import com.czxy.back.dao.OrderDao;
import com.czxy.back.dao.OrderDetailDao;
import com.czxy.back.service.OrderService;
import exceptions.OrderDetailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    /**
     * 更新订单
     * @param order
     * @return
     */
    @Override
    public boolean updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }


    /**
     * 删除订单
     * @param id
     * @return
     */
    @Override
    @Transactional
    public boolean deleteOrder(Integer id) {
        boolean result = false;
        try{
            int b = orderDetailDao.batchDeleteOrder(id);
            if(b >= 0){
                result = orderDao.deleteOrder(id);
            }else{
                throw new OrderDetailException("存在异常");
            }
        }catch (Exception e){
            throw new OrderDetailException("存在异常");
        }
        if(result)
            return true;
        else
            return false;
    }
}
