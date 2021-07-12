package com.goat.service;

import com.goat.entity.User;

/**
 * @author lwj
 * @version 1.0
 * @date 2021/7/7 21:59
 */
public interface UserService {

    User queryUserByUserName(String userName);

    boolean register(User user);

}
