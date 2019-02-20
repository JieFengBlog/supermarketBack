package com.czxy.back.service.impl;

import com.czxy.back.bean.User;
import com.czxy.back.dao.UserDao;
import com.czxy.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public boolean updateUserById(User user) {
        return userDao.updateUserById(user);
    }

    @Override
    public boolean deleteUserById(Integer id) {
        return userDao.deleteUserById(id);
    }


}
