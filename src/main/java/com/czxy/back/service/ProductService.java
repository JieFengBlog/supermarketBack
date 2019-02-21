package com.czxy.back.service;

import com.czxy.back.bean.Product;

import java.util.List;

public interface ProductService {

    /**
     * 通过id查询唯一商品信息
     * @param id
     * @return
     */
    Product getProductById(Integer id);

    /**
     * 获取所有的商品
     * @return
     */
    List<Product> getAllProducts(Integer type);

    /**
     * 模糊查询
     * @param product
     * @return
     */
    List<Product> getProductListByCondition(Product product);

    /**
     * 根据ID删除对应的商品
     * @param id
     * @return
     */
    Boolean deleteProductById(Integer id);

    /**
     * 批量删除商品
     * @param list
     * @return
     */
    Boolean batchDeleteProduct(List<Integer> list);

    /**
     * 添加一个商品
     * @param product
     * @return
     */
    Boolean addProduct(Product product);

    /**
     * 更新商品信息
     * @param product
     * @return
     */
    boolean updateProduct(Product product);


    /**
     * 获取商品的总数
     * @return
     */
    int countProduct();
}
