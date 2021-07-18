package com.goat.vo;/**
 * @author lwj
 * @date 2021/7/14 15:38
 * @version 1.0
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassNameNewBlogVo
 * @Descriprion
 * @AuthorLenovo
 * @Date 2021/7/1415:38
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewBlogVo {
        private String blogName;
        private String category;
        private String Introduct;
        private String content;
        private String username;
        private String[] tag;
        private boolean state;



}
