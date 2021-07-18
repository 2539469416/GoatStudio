package com.goat.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.dao.ArticleAddDao;
import com.goat.dao.TagDao;
import com.goat.entity.Article;
import com.goat.entity.ArticleTag;
import com.goat.service.ArticleAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

@Service
public class ArticleAddServiceImpl implements ArticleAddService {
    @Autowired
    private ArticleAddDao articleAddDao;


    @Override
    public Boolean addArticleAndTag(Article article) {
        articleAddDao.addArticle(article);
        //获取插入博客的ID
        Integer id = article.getId();
        List<Integer> tagNames = article.getTagList();
        for (Integer tagId : tagNames) {
            ArticleTag articleTag = new ArticleTag(id, tagId);
            articleAddDao.addArticleTag(articleTag);
        }

        return true;
    }

    @Override
    public List<Article> articleList(int start, int end) {
        PageHelper.startPage(start,end);
        List<Article> articles = articleAddDao.articleList();
        PageInfo pageInfo = new PageInfo(articles);
        return pageInfo.getList();
    }

    @Override
    public List<Article> shareList(int start, int end) {
        PageHelper.startPage(start,end);
        List<Article> articles = articleAddDao.shareList();
        PageInfo pageInfo = new PageInfo(articles);
        return pageInfo.getList();
    }

    @Override
    public Article getArticleInfo(int aid) {
        return articleAddDao.getArticleInfo(aid);
    }


}
