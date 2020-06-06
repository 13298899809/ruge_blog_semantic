package com.ruge.ruge_blog_semantic.service.impl;

import com.ruge.ruge_blog_semantic.domain.entitys.User;
import com.ruge.ruge_blog_semantic.repository.UserRepository;
import com.ruge.ruge_blog_semantic.service.UserService;
import com.ruge.ruge_blog_semantic.util.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName UserServiceImpl
 * @date 2020.06.04 15:36
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        // User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        User user = userRepository.findByUsernameAndPassword(username, password);
        return user;
    }
}
