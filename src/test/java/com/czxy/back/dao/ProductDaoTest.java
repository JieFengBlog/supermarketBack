package com.czxy.back.dao;

import com.czxy.back.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductDaoTest extends BaseTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void testGetProductInfoById(){
        Product product = productDao.getProductInfoById(1);
        System.out.println(product.getProductName());
    }
}
