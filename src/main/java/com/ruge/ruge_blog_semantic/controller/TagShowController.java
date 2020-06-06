package com.ruge.ruge_blog_semantic.controller;

import com.ruge.ruge_blog_semantic.domain.entitys.Tag;
import com.ruge.ruge_blog_semantic.service.BlogService;
import com.ruge.ruge_blog_semantic.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 标签管理
 * @date 2020/6/6 16:55
 */
@Controller
public class TagShowController {

    @Resource
    private TagService tagService;

    @Resource
    private BlogService blogService;

    /**
     * @param pageable {@link Pageable}
     * @param id       标签id
     * @param model    {@link Model}
     * @return 标签查询
     */
    @GetMapping("tags/{id}")
    public String types(@PageableDefault(size = 5, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                        @PathVariable Long id, Model model) {
        List<Tag> tags = tagService.listTagTop(100);
        if (id == -1) {
            id = tags.get(0).getId();
        }
        model.addAttribute("tags", tags);
        model.addAttribute("page", blogService.listBlog(id, pageable));
        model.addAttribute("activeTagId", id);
        return "tags";
    }
}
