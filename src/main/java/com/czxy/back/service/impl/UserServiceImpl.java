package com.czxy.back.service.impl;

import com.czxy.back.bean.User;
import com.czxy.back.dao.UserDao;
import com.czxy.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    /**
     * 验证用户登录凭证
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean validation(String username, String password) {
        User user = userDao.getUserByUsername(username);
        if(user == null){
            return false;
        }
        if(password.equals(user.getPassword())){
            return true;
        }

        return false;
    }
}
