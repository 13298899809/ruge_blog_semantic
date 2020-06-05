package com.ruge.ruge_blog_semantic.domain.entitys;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName Type
 * @date 2020.06.04 14:10
 */
@Getter
@Setter
@Entity
public class Type {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "分类名称不能为空")
    @Column(nullable = false,columnDefinition = "VARCHAR(50) default '' comment '分类名称'")
    private String name;
    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<>();
}
