package com.ruge.ruge_blog_semantic.repository;

import com.ruge.ruge_blog_semantic.domain.entitys.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName TagRepository
 * @date 2020.06.04 15:34
 */
public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag findByName(String name);
    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);
}
