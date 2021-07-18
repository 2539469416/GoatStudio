package com.goat.service.impl;

import com.goat.dao.CategoryDao;
import com.goat.entity.Category;
import com.goat.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
   @Autowired
   private CategoryDao categoryDao;
    @Override
    public List<Category> loadAllCategory() {

        return categoryDao.selectAllCategory();
    }
}
