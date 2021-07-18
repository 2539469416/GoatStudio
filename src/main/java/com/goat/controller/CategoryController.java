package com.goat.controller;/**
 * @author lwj
 * @date 2021/7/15 10:13
 * @version 1.0
 */

import com.goat.service.impl.CategoryServiceImpl;
import com.goat.util.ResultUtil;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassNameCategoryController
 * @Descriprion
 * @AuthorLenovo
 * @Date 2021/7/1510:13
 * @Version 1.0
 */
@RestController
@RequestMapping("/article")
@Api(description = "文章分类查询")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;
    private static Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @RequestMapping("/ArtClassData")
    public ResultUtil artClassData(){

       List category =  categoryServiceImpl.loadAllCategory();

       if (category == null){
           return ResultUtil.buildResult(ResultUtil.Status.NOT_FOUND,"分类数据为空");
       }
       return  ResultUtil.buildResult(ResultUtil.Status.OK,category);
    }
}
