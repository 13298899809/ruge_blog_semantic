package com.ruge.ruge_blog_semantic.service;

import com.ruge.ruge_blog_semantic.domain.entitys.User;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName UserService
 * @date 2020.06.04 15:36
 */
public interface UserService {
    User checkUser(String username, String password);
}
