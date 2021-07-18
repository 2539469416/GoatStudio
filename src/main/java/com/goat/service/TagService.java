package com.goat.service;

import com.goat.entity.Tag;

import java.util.List;

/**
 * @author lwj
 * @version 1.0
 * @date 2021/7/7 14:30
 */

public interface TagService {
     List<Tag> findAllTag();

    Tag queryIdByName(String tagName);
}
