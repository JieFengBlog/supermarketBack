package com.czxy.back.service;


public interface ValidationService {

    /**
     * 验证用户信息
     * @param username
     * @param password
     * @return
     */
    boolean validation(String username,String password);
}
