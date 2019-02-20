package com.czxy.back.service;

import com.czxy.back.bean.User;

import java.util.List;

public interface UserService {

    /**
     * 添加用户
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */

    User getUserById(Integer id);

    /**
     * 获取所有用户
     * @return
     */
    List<User> getAllUser();

    /**
     * 更细用户
     * @param user
     * @return
     */
    boolean updateUserById(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    boolean deleteUserById(Integer id);

}
