package com.ruge.ruge_blog_semantic.service;

import com.ruge.ruge_blog_semantic.domain.entitys.Blog;
import com.ruge.ruge_blog_semantic.domain.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName BlogService
 * @date 2020.06.04 16:41
 */
public interface BlogService {

    Blog getBlog(Long id);

    Blog getAndConvert(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(Long tagId,Pageable pageable);

    Page<Blog> listBlog(String query,Pageable pageable);

    List<Blog> listRecommendBlogTop(Integer size);

    Map<String,List<Blog>> archiveBlog();

    Long countBlog();

    Blog saveBlog(Blog blog);

    void updateBlog(Long id,Blog blog);

    void deleteBlog(Long id);
}
