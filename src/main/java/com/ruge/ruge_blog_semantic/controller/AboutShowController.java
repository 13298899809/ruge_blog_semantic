package com.ruge.ruge_blog_semantic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 关于我
 * @date 2020/6/6 16:51
 */
@Controller
public class AboutShowController {
    /**
     * @return 关于我
     */
    @GetMapping("/about")
    public String about() {
        return "about";
    }
}

