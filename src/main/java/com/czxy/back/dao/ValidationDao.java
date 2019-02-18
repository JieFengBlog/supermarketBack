package com.czxy.back.dao;

import com.czxy.back.bean.Validation;

public interface ValidationDao {

    /**
     * 获取用户信息
     * @return
     */
    Validation getUserByUsername(String username);
}
