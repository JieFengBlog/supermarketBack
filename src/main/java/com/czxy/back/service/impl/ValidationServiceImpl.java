package com.czxy.back.service.impl;

import com.czxy.back.bean.Validation;
import com.czxy.back.dao.ValidationDao;
import com.czxy.back.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("validationService")
public class ValidationServiceImpl implements ValidationService {

    @Autowired
    private ValidationDao validationDao;

    /**
     * 验证用户登录凭证
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean validation(String username, String password) {
        Validation validation = validationDao.getUserByUsername(username);
        if(validation == null){
            return false;
        }
        if(password.equals(validation.getPassword())){
            return true;
        }

        return false;
    }
}
