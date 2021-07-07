package com.goat.service.impl;/**
 * @author lwj
 * @date 2021/7/7 14:31
 * @version 1.0
 */

import com.goat.dao.TagGYDao;
import com.goat.entity.TagGY;
import com.goat.service.TagGYService;
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
public class TagGYServiceImpl implements TagGYService {
    @Autowired
    private TagGYDao tagGYDao;

    @Override
    public List<TagGY> findAllTag() {
        return tagGYDao.findAllTag();
    }
}
