package com.czxy.back.service;

import com.czxy.back.bean.Order;

import java.util.List;

public interface OrderService {

    /**
     * 进货
     * @return
     */
     String orderIn(String inListJSON);


}
