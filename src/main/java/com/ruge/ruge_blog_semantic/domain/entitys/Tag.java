package com.ruge.ruge_blog_semantic.domain.entitys;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName Tag
 * @date 2020.06.04 14:11
 */
@Getter
@Setter
@Entity
public class Tag {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false,columnDefinition = "VARCHAR(50) default '' comment '标签名称'")
    private String name;
    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs = new ArrayList<>();

}
