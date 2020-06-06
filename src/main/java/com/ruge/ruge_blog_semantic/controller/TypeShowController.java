package com.ruge.ruge_blog_semantic.controller;

import com.ruge.ruge_blog_semantic.domain.entitys.Type;
import com.ruge.ruge_blog_semantic.domain.vo.BlogQuery;
import com.ruge.ruge_blog_semantic.service.BlogService;
import com.ruge.ruge_blog_semantic.service.TypeService;
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
 * @Description: 类型查询
 * @date 2020/6/6 16:56
 */

@Controller
public class TypeShowController {

    @Resource
    private TypeService typeService;

    @Resource
    private BlogService blogService;

    /**
     * @param pageable {@link Pageable}
     * @param id       类型id
     * @param model    {@link Model}
     * @return 类型查询
     */
    @GetMapping("types/{id}")
    public String types(@PageableDefault(size = 5, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                        @PathVariable Long id, Model model) {
        List<Type> types = typeService.listTypeTop(100);
        if (id == -1) {
            id = types.get(0).getId();
        }
        BlogQuery blogVO = new BlogQuery();
        blogVO.setTypeId(id);
        model.addAttribute("types", types);
        model.addAttribute("page", blogService.listBlog(pageable, blogVO));
        model.addAttribute("activeTypeId", id);
        return "types";
    }
}

