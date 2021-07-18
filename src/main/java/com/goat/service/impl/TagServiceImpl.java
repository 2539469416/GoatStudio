package com.goat.service.impl;/**
 * @author lwj
 * @date 2021/7/7 14:31
 * @version 1.0
 */

import com.goat.dao.TagDao;
import com.goat.entity.Tag;
import com.goat.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassNameTagGYService
 * @Descriprion
 * @AuthorLenovo
 * @Date 2021/7/714:31
 * @Version 1.0
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagDao tagDao;

    @Override
    public List<Tag> findAllTag() {
        return tagDao.findAllTag();
    }

    @Override
    public Tag queryIdByName(String tagName) {
        return tagDao.queryIdByName(tagName);
    }
}
