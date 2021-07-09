package com.goat.service.impl;/**
 * @author lwj
 * @date 2021/7/7 21:59
 * @version 1.0
 */

import com.goat.dao.UserDao;
import com.goat.entity.User;
import com.goat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassNameUserServiceImpl
 * @Descriprion
 * @AuthorLenovo
 * @Date 2021/7/721:59
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User queryUserByUserName(String userName) {
        return userDao.queryUserByUserName(userName);
    }
}
