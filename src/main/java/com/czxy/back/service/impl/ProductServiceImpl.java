package com.czxy.back.service.impl;

import com.czxy.back.bean.Product;
import com.czxy.back.bean.ProductCount;
import com.czxy.back.dao.ProductDao;
import com.czxy.back.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Map<String, Object>> productCountTopAndEndFiveService(int type) {
        List<Map<String, Object>> list =  new ArrayList<>();
        List<ProductCount> productCounts = null;
        if(type == 1){
            productCounts = productDao.productCountTopAndEndFive(1);
        }else{
            productCounts = productDao.productCountTopAndEndFive(0);
        }
        return  getList(list, productCounts);
    }

    private static List<Map<String, Object>> getList(List<Map<String, Object>> list, List<ProductCount> productCounts) {
        for (ProductCount item : productCounts) {
            Map<String,Object> map = new HashMap<>();
            map.put("商品",item.getName());
            map.put("销售量",item.getNumber());
            map.put("销售额",item.getPrice());
            list.add(map);
        }
        return list;
    }


}
