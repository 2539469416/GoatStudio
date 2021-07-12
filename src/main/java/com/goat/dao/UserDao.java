package com.goat.dao;

import com.goat.entity.User;
import org.apache.ibatis.annotations.Param;

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
     * @param user
     * @return
     */
    boolean register(User user);

}
