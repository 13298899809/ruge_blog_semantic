package com.ruge.ruge_blog_semantic.controller;

import com.ruge.ruge_blog_semantic.domain.entitys.Comment;
import com.ruge.ruge_blog_semantic.domain.entitys.User;
import com.ruge.ruge_blog_semantic.service.BlogService;
import com.ruge.ruge_blog_semantic.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 评论控制层
 * @date 2020/6/6 16:52
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    //默认头像
    @Value("${comment.avatar}")
    private String avatar;

    /**
     * @param blogId 博客id
     * @param model  {@link Model}
     * @return 博客查询
     */
    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model) {
        model.addAttribute("comments", commentService.listCommentByBlogId(blogId));
        return "blog :: commentList";
    }

    /**
     * @param comment    {@link Comment}
     * @param attributes {@link RedirectAttributes}
     * @param session    {@link HttpSession}
     * @return 新增评论
     */
    @PostMapping("/comments")
    public String post(Comment comment, RedirectAttributes attributes, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
            comment.setNickname(user.getNickname());
        } else {
            //设置默认头像
            comment.setAvatar(avatar);
        }
        Comment commentResult = commentService.saveComment(comment);
        Long blogId = comment.getBlog().getId();
        comment.setBlog(blogService.getBlog(blogId));

        if (commentResult == null) {
            attributes.addFlashAttribute("message", "回复失败");
        } else {
            attributes.addFlashAttribute("message", "回复成功");
        }
        return "redirect:/comments/" + blogId;
    }
}
