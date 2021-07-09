package com.goat.jwt;/**
 * @author lwj
 * @date 2021/7/9 10:57
 * @version 1.0
 */

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.goat.entity.User;

/**
 * @ClassNameTokenUtil
 * @Descriprion
 * @AuthorLenovo
 * @Date 2021/7/910:57
 * @Version 1.0
 */
public class TokenUtil {
    public static String getToken(User user){
        String token="";
        token= JWT.create().withAudience(user.getUserName())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
