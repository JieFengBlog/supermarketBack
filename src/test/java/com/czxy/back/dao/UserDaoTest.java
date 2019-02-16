package com.czxy.back.dao;

import com.czxy.back.BaseTest;
import com.czxy.back.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoTest extends BaseTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testgetUser(){
        String username = "admin1";
        User user = userDao.getUserByUsername(username);
        System.out.println(user.getUsername());
    }
}