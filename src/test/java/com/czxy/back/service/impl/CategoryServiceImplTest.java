package com.czxy.back.service.impl; 

import com.czxy.back.BaseTest;
import com.czxy.back.bean.Category;
import com.czxy.back.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/** 
* CategoryServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>02/11/2019</pre> 
* @version 1.0 
*/ 
public class CategoryServiceImplTest extends BaseTest {

    @Autowired
    private CategoryService categoryService;

    /**
    * Method: getAllCategory() 
    */ 
    @Test
    public void testGetAllCategory() throws Exception {
        List<Category> list = categoryService.getAllCategory();
        System.out.println(list);
    } 
    
        
    } 
