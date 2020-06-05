package com.ruge.ruge_blog_semantic.repository;

import com.ruge.ruge_blog_semantic.domain.entitys.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName TypeRepository
 * @date 2020.06.04 15:35
 */
public interface TypeRepository extends JpaRepository<Type,Long> {
    Type findByName(String name);
    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);
}
