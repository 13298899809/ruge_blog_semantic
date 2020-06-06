package com.ruge.ruge_blog_semantic.controller;

import com.ruge.ruge_blog_semantic.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 归档管理
 * @date 2020/6/6 16:52
 */
@Controller
public class ArchiveShowController {

    @Autowired
    private BlogService blogService;

    /**
     * @param model {@link Model}
     * @return 归档查询
     */
    @GetMapping("/archives")
    public String archives(Model model) {
        model.addAttribute("archiveMap", blogService.archiveBlog());
        model.addAttribute("blogCount", blogService.countBlog());
        return "archives";
    }
}
