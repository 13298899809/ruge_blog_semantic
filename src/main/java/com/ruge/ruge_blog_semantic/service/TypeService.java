package com.ruge.ruge_blog_semantic.service;

import com.ruge.ruge_blog_semantic.domain.entitys.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName TypeService
 * @date 2020.06.04 15:37
 */
public interface TypeService {
    /**
     * @param type {@link Type}
     * @return type保存
     */
    Type saveType(Type type);

    /**
     * @param id id
     * @return 获取type
     */
    Type getType(Long id);

    /**
     * @param name 类型名称
     * @return 通过类型名称查询
     */
    Type getTypeByName(String name);

    /**
     * @param pageable {@link Pageable}
     * @return 分页查询type
     */
    Page<Type> listType(Pageable pageable);

    /**
     * @return 查询全部
     */
    List<Type> listType();

    List<Type> listTypeTop(Integer size);

    /**
     * 修改类型
     *
     * @param type {@link Type}
     */
    void updateType(Long id, Type type);

    /**
     * 删除type
     *
     * @param id id
     */
    void deleteType(Long id);
}
