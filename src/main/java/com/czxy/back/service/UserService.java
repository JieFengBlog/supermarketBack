package com.czxy.back.service;

public interface UserService {

    /**
     * 验证用户信息
     * @param username
     * @param password
     * @return
     */
    boolean validation(String username,String password);
}
