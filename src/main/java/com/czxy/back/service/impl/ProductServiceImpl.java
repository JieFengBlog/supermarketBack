package com.czxy.back.service.impl;

import com.czxy.back.bean.Product;
import com.czxy.back.dao.ProductDao;
import com.czxy.back.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    /**
     * 根据ID获取商品
     * @param id
     * @return
     */
    @Override
    public Product getProductById(Integer id) {

        return productDao.getProductById(id);
    }

    /**
     * 获取所有的商品
     * @return
     */
    @Override
    public List<Product> getAllProducts(Integer type) {
        return productDao.getAllProducts(type);
    }


    /**
     * 模糊查询
     * @param product
     * @return
     */
    @Override
    public List<Product> getProductListByCondition(Product product) {
        return productDao.getProductListByCondition(product);
    }


    /**
     * 根据ID删除单个商品
     * @param id
     * @return
     */
    @Override
    public Boolean deleteProductById(Integer id) {
        Boolean result = productDao.deleteProductById(id);
        return result;
    }


    /**
     * 批量删除商品
     * @param list
     * @return
     */
    @Override
    public Boolean batchDeleteProduct(List<Integer> list) {
        return productDao.batchDeleteProduct(list);
    }

    /**
     * 添加一个商品
     * @param product
     * @return
     */
    @Override
    public Boolean addProduct(Product product) {
       return productDao.addProduct(product);
    }

    /**
     * 更新商品信息
     * @param product
     * @return
     */
    public boolean updateProduct(Product product){
        return productDao.updateProduct(product);
    }

    @Override
    public int countProduct() {
        return productDao.countProduct();
    }

}
