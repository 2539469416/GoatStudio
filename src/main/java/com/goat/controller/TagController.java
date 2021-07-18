package com.goat.controller;/**
 * @author lwj
 * @date 2021/7/7 10:42
 * @version 1.0
 */


import com.goat.entity.Tag;
import com.goat.service.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassNameTagGYController
 * @Descriprion
 * @AuthorLenovo
 * @Date 2021/7/710:42
 * @Version 1.0
 */
@RestController
public class TagController {
    @Autowired
    private TagServiceImpl tagServiceImpl;

    @RequestMapping("/tagList")
    public ModelAndView TagList(Model model){
        List<Tag> tagList = tagServiceImpl.findAllTag();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tagLists",tagList);
        modelAndView.setViewName("tagLists");
        return modelAndView;
    }

}
