package com.goat.service;

import com.goat.entity.TagGY;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lwj
 * @version 1.0
 * @date 2021/7/7 14:30
 */

public interface TagGYService {
    public List<TagGY> findAllTag();
}
