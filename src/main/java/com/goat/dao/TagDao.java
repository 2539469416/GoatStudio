package com.goat.dao;

import com.goat.entity.Tag;


import java.util.List;

/**
 * @author lwj
 * @version 1.0
 * @date 2021/7/7 9:39
 */
public interface TagDao {
     List<Tag> findAllTag();

    Tag queryIdByName(String tagName);

}
