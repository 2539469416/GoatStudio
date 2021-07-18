package com.goat.dao;


import com.goat.entity.Article;
import com.goat.entity.ArticleTag;

import java.util.List;

public interface ArticleAddDao {

     boolean addArticleTag(ArticleTag articleTag);

     boolean addArticle(Article article);

     List<Article> articleList();

     List<Article> shareList();

     Article getArticleInfo(int aid);
}
