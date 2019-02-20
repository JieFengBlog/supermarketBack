package com.czxy.back.dao;

import com.czxy.back.BaseTest;
import com.czxy.back.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoTest extends BaseTest {


    @Autowired
    private UserDao userDao;

    @Test
    public void testUpdateUser(){
        User user =  new User();
        user.setId(1);
        user.setName("jack222");
        user.setEmail("jack222@gmail.com");
        boolean result = userDao.updateUserById(user);
        System.out.println(result);
    }

    @Test
    public void testDeleteUser(){
        boolean re = userDao.deleteUserById(1);
        System.out.println(re);
    }

}