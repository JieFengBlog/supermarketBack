package com.czxy.back.dao;

import com.czxy.back.bean.User;

import java.util.List;

public interface UserDao {

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 添加用户
     * @param user
     * @return
     */
    boolean addUser(User user);


    List<User> getAllUser();

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    boolean updateUserById(User user);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    boolean deleteUserById(Integer id);

}
