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
 * @ClassName Comment
 * @date 2020.06.04 14:11
 */
@Getter
@Setter
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false,columnDefinition = "VARCHAR(50) default '' comment '评论昵称'")
    private String nickname;
    @Column(nullable = false,columnDefinition = "VARCHAR(50) default '' comment '评论邮箱'")
    private String email;
    @Column(nullable = false,columnDefinition = "VARCHAR(50) default '' comment '评论内容'")
    private String content;
    @Column(nullable = false,columnDefinition = "VARCHAR(255) default '' comment '评论头像'")
    private String avatar;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @ManyToOne
    private Blog blog;
    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments = new ArrayList<>();
    @ManyToOne
    private Comment parentComment;
    private boolean adminComment;
}
