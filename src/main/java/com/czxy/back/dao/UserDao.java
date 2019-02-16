package com.czxy.back.dao;

import com.czxy.back.bean.User;

public interface UserDao {

    /**
     * 获取用户信息
     * @return
     */
    User getUserByUsername(String username);
}
