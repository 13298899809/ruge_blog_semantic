package com.ruge.ruge_blog_semantic.repository;

import com.ruge.ruge_blog_semantic.domain.entitys.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName CommentRepository
 * @date 2020.06.04 15:34
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);
}
