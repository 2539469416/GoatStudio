package com.goat.dao;

import com.goat.entity.User;

/**
 * @author lwj
 * @version 1.0
 * @date 2021/7/7 21:52
 */
public interface UserDao {

    /**
     * 根据账号查用户
     * @param userName
     * @return
     */
    User queryUserByUserName(String userName);

    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    boolean register(String username,String password);

}
