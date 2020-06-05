package com.ruge.ruge_blog_semantic.service;

import com.ruge.ruge_blog_semantic.domain.entitys.Comment;

import java.util.List;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName CommentService
 * @date 2020.06.04 16:38
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
