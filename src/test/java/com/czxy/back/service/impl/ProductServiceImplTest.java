package com.czxy.back.service.impl; 

import com.czxy.back.BaseTest;
import com.czxy.back.bean.Category;
import com.czxy.back.bean.Product;
import com.czxy.back.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
* ProductServiceImpl Tester.
*
* @author <Authors name>
* @since <pre>02/02/2019</pre>
* @version 1.0
*/
public class ProductServiceImplTest extends BaseTest {

    @Autowired
    private ProductService productService;

    /**
    * Method: getProductById(Integer id)
    */
    @Test
    public void testGetProductById() throws Exception {
    //TODO: Test goes here...
    }

    /**
    * Method: getAllProducts()
    */
    @Test
    public void testGetAllProducts() throws Exception {
    //TODO: Test goes here...
        List<Product> productList = productService.getAllProducts();
        for(Product item:productList){
            System.out.println(item);
        }
    }

    @Test
    public void testAddProduct(){
        Product product = new Product();
        product.setName("葡萄");
        product.setPrice(4);
        product.setProductDesc("很甜");
        product.setStatus(true);
        product.setStock(120);
        product.setCreateTime(new Date());
        product.setLastEditTime(new Date());
        product.setCategory(new Category(1,null));
        product.setProvide("山西省");
        Boolean result = productService.addProduct(product);
        System.out.println(result);
    }
}