package com.czxy.back.service.impl; 

import com.czxy.back.BaseTest;
import com.czxy.back.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/** 
* UserService Tester.
* 
* @author <Authors name> 
* @since <pre>02/16/2019</pre> 
* @version 1.0 
*/ 
public class DaoServiceImplTest extends BaseTest {


    @Autowired
    private UserService userService;

    /**
    * Method: validation(String username, String password) 
    */ 
    @Test
    public void testValidation() throws Exception { 
        String username = "admin";
        String password = "123456";

        boolean result = userService.validation(username,password);
        System.out.println(result);
    } 
    
        
    } 
