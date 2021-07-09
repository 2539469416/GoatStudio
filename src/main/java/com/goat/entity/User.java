package com.goat.entity;/**
 * @author lwj
 * @date 2021/7/7 21:49
 * @version 1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassNameUser
 * @Descriprion
 * @AuthorLenovo
 * @Date 2021/7/721:49
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer Id;
    private String userName;
    private String password;

}
