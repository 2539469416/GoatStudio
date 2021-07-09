package com.goat.vo;/**
 * @author lwj
 * @date 2021/7/9 14:38
 * @version 1.0
 */

import com.goat.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassNameLoginUserVo
 * @Descriprion
 * @AuthorLenovo
 * @Date 2021/7/914:38
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserVo {
    private User user;
    private String token;
}
