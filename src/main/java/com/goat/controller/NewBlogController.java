package com.goat.controller;/**
 * @author lwj
 * @date 2021/7/12 11:16
 * @version 1.0
 */

import com.goat.util.ImgUtil;
import com.goat.util.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @ClassNameNewBlog
 * @Descriprion
 * @AuthorLenovo
 * @Date 2021/7/1211:16
 * @Version 1.0
 */
@RestController
public class NewBlogController {


    @RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
    public ResultUtil<String> ImgUpload(@RequestParam("file") MultipartFile multipartFile){


        try{
            String key = ImgUtil.upload(multipartFile);
            System.out.println(key);
            return ResultUtil.buildResult(ResultUtil.Status.OK,key);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.buildResult(ResultUtil.Status.ERROR,"未知错误");
        }

    }


}
