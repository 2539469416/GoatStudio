package com.goat.controller;/**
 * @author lwj
 * @date 2021/7/15 11:20
 * @version 1.0
 */

import com.github.pagehelper.PageInfo;
import com.goat.entity.Article;
import com.goat.service.impl.ArticleAddServiceImpl;
import com.goat.util.ResultUtil;
import com.goat.vo.ShareListVo;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassNameShowArticleController
 * @Descriprion
 * @AuthorLenovo
 * @Date 2021/7/1511:20
 * @Version 1.0
 */
@RestController
@Api(description = "查询文章")
public class ShowArticleController {
    @Autowired
    private ArticleAddServiceImpl articleAddServiceImpl;
    private static Logger logger = LoggerFactory.getLogger(ShowArticleController.class);

    //获取文章列表
    @RequestMapping("/nav/ActiveClassAllData")
    public ResultUtil activeClassAllData(Integer artId,Integer cateId,String articleName){
            if(cateId-artId<=0){
                return ResultUtil.buildResult(ResultUtil.Status.ERROR,"数据异常");
            }
            logger.info(artId+"-"+cateId+"-"+articleName);
            List<Article> articles= articleAddServiceImpl.shareList(artId,cateId);
            for(Article article :articles){
               logger.info("artId:"+article.getId());
            }
            if (articles==null){
                return ResultUtil.buildResult(ResultUtil.Status.NOT_FOUND,"没有数据了");
            }
            logger.info("查询成功");
            return ResultUtil.buildResult(ResultUtil.Status.OK,articles);
    }

    @RequestMapping("/article/getArticleInfo")
    //获取文章详情
    public ResultUtil getArticleInfo(int aId,String userId){
        logger.info("文章详情"+aId+"user"+userId);
        if(userId.equals("undefined")){
            Article article = articleAddServiceImpl.getArticleInfo(aId);
            return ResultUtil.buildResult(ResultUtil.Status.OK,article);
        }

        return null;
    }
}
