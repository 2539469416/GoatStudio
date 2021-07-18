package com.goat.entity;/**
 * @author lwj
 * @date 2021/7/7 9:35
 * @version 1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassNameTagGY
 * @Descriprion
 * @AuthorLenovo
 * @Date 2021/7/79:35
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag implements Serializable {
    private Integer id;
    private String tagName;

}
