package com.ruge.ruge_blog_semantic.repository;

import com.ruge.ruge_blog_semantic.domain.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName UserRepository
 * @date 2020.06.04 15:35
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
}
