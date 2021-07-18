package com.goat.service;


import com.goat.entity.Article;

import java.util.List;

public interface ArticleAddService {



     Boolean addArticleAndTag(Article article);

     List<Article> articleList(int start, int end);

     List<Article> shareList(int start, int end);

     Article getArticleInfo(int aid);
}
