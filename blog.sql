create database blog;
#文章表
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
                             `id` int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                             `categoryId` int(10) NOT NULL COMMENT '分类Id',
                             `title` varchar(40) NOT NULL COMMENT '标题',
                             `content` blob NOT NULL COMMENT '内容',
                             `description` varchar(450) NOT NULL COMMENT '文章简介  用于列表显示',
                             `statue` int(10) NOT NULL DEFAULT '0' COMMENT '状态 0：正常  1：不可用',
                             `author` varchar(15) DEFAULT 'tulun' COMMENT '作者',
                             `createTime` datetime NOT NULL COMMENT '发表时间',
                             `showCount` int(10) NOT NULL DEFAULT '0' COMMENT '浏览量'
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='文章表';

# 文章图表
DROP TABLE IF EXISTS `t_article_image`;
CREATE TABLE `t_article_image` (
                                   `id` int(10) NOT NULL AUTO_INCREMENT,
                                   `imageUrl` varchar(100) NOT NULL COMMENT '图片地址',
                                   `articleId` int(10) NOT NULL COMMENT '文章Id',
                                   PRIMARY KEY (`id`,`articleId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='文章图  主要用于列表浏览';

# 标签表
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
                         `id` int(10) NOT NULL AUTO_INCREMENT,
                         `tagName` varchar(25) NOT NULL COMMENT '标签名称  唯一',
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `tagName_UNIQUE` (`tagName`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='标签表';

# 文章标签中间表
DROP TABLE IF EXISTS `t_article_tag`;
CREATE TABLE `t_article_tag` (
                                 `articleId` int(10) NOT NULL COMMENT '文章Id',
                                 `tagId` int(10) NOT NULL COMMENT '标签Id',
                                 PRIMARY KEY (`articleId`,`tagId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章标签中间表';

# 分类表
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
                              `id` int(10) NOT NULL AUTO_INCREMENT,
                              `categoryName` varchar(20) NOT NULL COMMENT '分类名称  唯一',
                              `iconClass` varchar(45) NOT NULL COMMENT '图标样式',
                              `aliasName` varchar(20) NOT NULL COMMENT '别名  唯一  比如新闻 就用News 代替  栏目Id不显示在url中',
                              `sort` int(10) NOT NULL DEFAULT '0' COMMENT '排序 （0-10）',
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `aliasName_UNIQUE` (`aliasName`),
                              UNIQUE KEY `categoryName_UNIQUE` (`categoryName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分类表  只支持一级分类  如果需要分多个层次 用标签来协助实现';

#管理员表
DROP TABLE IF EXISTS `t_manager`;
CREATE TABLE `t_manager` (
                             `id` int(10) NOT NULL AUTO_INCREMENT,
                             `userName` varchar(25) NOT NULL COMMENT '用户名',
                             `password` varchar(45) NOT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
show tables ;