package com.goat.controller;/**
 * @author lwj
 * @date 2021/7/12 11:16
 * @version 1.0
 */

import com.goat.entity.Article;
import com.goat.service.TagService;
import com.goat.service.impl.ArticleAddServiceImpl;
import com.goat.service.impl.TagServiceImpl;
import com.goat.util.ImgUtil;
import com.goat.util.ResultUtil;
import com.goat.vo.NewBlogVo;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassNameNewBlog
 * @Descriprion
 * @AuthorLenovo
 * @Date 2021/7/1211:16
 * @Version 1.0
 */
@RestController
@Api(description = "新增博客")
public class NewBlogController {
    @Autowired
    private ArticleAddServiceImpl articleAddServiceImpl;
    @Autowired
    private TagServiceImpl tagServiceImpl;

    private static Logger logger = LoggerFactory.getLogger(NewBlogController.class);

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


    @RequestMapping(value = "/newBlog",method = RequestMethod.POST)
    public ResultUtil newBlog(NewBlogVo newBlogVo){
        logger.info(newBlogVo.getUsername()+"用户发表");
        if (newBlogVo.getTag()==null){
            return ResultUtil.buildResult(ResultUtil.Status.ERROR,"标签为空");
        }
      try{
          Article article = new Article();
          article.setTitle(newBlogVo.getBlogName());
          article.setCategoryId(1);
          article.setContent(newBlogVo.getContent());
          article.setDescription(newBlogVo.getIntroduct());
          int state = newBlogVo.isState()?0:1;
          article.setStatue(state);
          article.setAuthor(newBlogVo.getUsername());
          article.setCreateTime(LocalDateTime.now());
          article.setShowCount(0);
          List<Integer> tagId = new ArrayList<>();
          String[] tags = newBlogVo.getTag();
          for (String tagName :tags){
              tagId.add(tagServiceImpl.queryIdByName(tagName).getId());
          }
          article.setTagList(tagId);
          articleAddServiceImpl.addArticleAndTag(article);
          logger.info("发表成功");
          return ResultUtil.buildResult(ResultUtil.Status.OK,"ok");
      }catch (Exception e){
          return ResultUtil.buildResult(ResultUtil.Status.SERVICE_UNAVAILABLE);
      }

    }


}
