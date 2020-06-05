package com.ruge.ruge_blog_semantic.domain.entitys;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName User
 * @date 2020.06.04 14:08
 */
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, columnDefinition = "VARCHAR(50) default '' comment '昵称'")
    private String nickname;
    @Column(nullable = false, columnDefinition = "VARCHAR(50) default '' comment '用户名'")
    private String username;
    @Column(nullable = false, columnDefinition = "VARCHAR(50) default '' comment '密码'")
    private String password;
    @Column(nullable = false, columnDefinition = "VARCHAR(50) default '' comment '邮箱'")
    private String email;
    @Column(nullable = false, columnDefinition = "VARCHAR(255) default '' comment '头像'")
    private String avatar;
    @Column(nullable = false, columnDefinition = "VARCHAR(50) default '' comment '用户类型'")
    private Integer type;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @OneToMany(mappedBy = "user")
    private List<Blog> blogs = new ArrayList<>();
}
