package com.czxy.back.dao;

public interface ProductDao {

    /**
     * 根据id获取商品的信息
     * @param id
     * @return
     */
    Product getProductInfoById(Integer id);
}
