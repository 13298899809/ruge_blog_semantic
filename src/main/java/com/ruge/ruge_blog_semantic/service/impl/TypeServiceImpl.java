package com.ruge.ruge_blog_semantic.service.impl;

import com.ruge.ruge_blog_semantic.domain.entitys.Type;
import com.ruge.ruge_blog_semantic.repository.TypeRepository;
import com.ruge.ruge_blog_semantic.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName TypeServiceImpl
 * @date 2020.06.04 15:38
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.findById(id).get();
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

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


    @Transactional
    @Override
    public void updateType(Long id, Type type) {
        typeRepository.findById(id).ifPresent(e -> {
            BeanUtils.copyProperties(type, e);
            typeRepository.save(e);
        });
    }


    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }
}
