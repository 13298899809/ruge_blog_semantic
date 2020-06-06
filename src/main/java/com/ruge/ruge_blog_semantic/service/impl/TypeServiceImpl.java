package com.ruge.ruge_blog_semantic.service.impl;

import com.ruge.ruge_blog_semantic.domain.entitys.Type;
import com.ruge.ruge_blog_semantic.repository.TypeRepository;
import com.ruge.ruge_blog_semantic.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName TypeServiceImpl
 * @date 2020.06.04 15:38
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Resource
    private TypeRepository typeRepository;

    /**
     * @param type {@link Type}
     * @return type保存
     */
    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    /**
     * @param id id
     * @return 获取type
     */
    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.findById(id).get();
    }

    /**
     * @param name 类型名称
     * @return 通过类型名称查询
     */
    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    /**
     * @param pageable {@link Pageable}
     * @return 分页查询type
     */
    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    /**
     * @return 查询全部
     */
    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }


    @Override
    public List<Type> listTypeTop(Integer size) {
        Sort sort = Sort.by(Sort.Order.desc("blogs.size"));
        Pageable pageable = PageRequest.of(0, size, sort);
        return typeRepository.findTop(pageable);
    }

    /**
     * 修改类型
     *
     * @param type {@link Type}
     */
    @Transactional
    @Override
    public void updateType(Long id, Type type) {
        typeRepository.findById(id).ifPresent(e -> {
            BeanUtils.copyProperties(type, e);
            typeRepository.save(e);
        });
    }

    /**
     * 删除type
     *
     * @param id id
     */
    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }
}
