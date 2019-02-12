package com.czxy.back.dao;

import com.czxy.back.BaseTest;
import com.czxy.back.bean.Category;
import com.czxy.back.bean.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDaoTest extends BaseTest {

    @Autowired
    private ProductDao productDao;

    /**
     * 测试根据ID查询商品信息
     */
    @Test
    public void testGetProductById(){
        Product product = productDao.getProductById(1);
        System.out.println(product);
    }


    @Test
    public void testGetCategoryListByCondition(){
        Product condition = new Product();
        condition.setName("ccc");
        condition.setProvide("ccc");
        List<Product> list = productDao.getProductListByCondition(condition);
        for(Product item:list){
            System.out.println(item);
        }
    }


    @Test
    public void testDeleteProductById(){
        Boolean result = productDao.deleteProductById(2);
        System.out.println(result);
    }


    @Test
    public void addProduct(){
        Product product = new Product();
        product.setProductDesc("新添加的香蕉");
        product.setPrice(5);
        Category category = new Category();
        category.setId(1);
        product.setCategory(category);
        product.setStock(200);
        product.setProvide("河南省");
        product.setStatus(false);
        product.setCreateTime(new Date());
        product.setLastEditTime(new Date());
        for(int i = 30; i < 81; i++){
            product.setName("香蕉" + i);
            Boolean result = productDao.addProduct(product);
        }
    }

    @Test
    public void testBatchDeleteProduct(){
        List<Integer> list = new ArrayList<>();
        list.add(21);
        list.add(23);
        list.add(24);
        Boolean result = productDao.batchDeleteProduct(list);
        System.out.println(result);
    }


    @Test
    public void testUpdateProduct(){
        Product product = new Product();
        product.setId(27);
        product.setName("香蕉名称被改了");
        boolean result = productDao.updateProduct(product);
        System.out.println(result);
    }
}
