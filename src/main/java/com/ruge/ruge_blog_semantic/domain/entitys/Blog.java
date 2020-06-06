package com.ruge.ruge_blog_semantic.domain.entitys;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName Blog
 * @date 2020.06.04 14:07
 */
@Getter
@Setter
@Entity
public class Blog {
    @Id
    @GeneratedValue
    @Column(nullable = false, columnDefinition = "INTEGER comment '主键'")
    private Long id;
    @Column(nullable = false, columnDefinition = "VARCHAR(50) default '' comment '标题'")
    private String title;
    @Basic(fetch = FetchType.LAZY)
    @Lob
    @Column(nullable = false, columnDefinition = "BLOB  comment '博客内容'")
    private String content;
    @Column(nullable = false, columnDefinition = "BLOB  comment '首图'")
    private String firstPicture;
    @Column(nullable = false, columnDefinition = "VARCHAR(50) default '' comment '标记'")
    private String flag;
    @Column(nullable = false, columnDefinition = "INTEGER default '0' comment '浏览次数'")
    private int views;
    @Column(nullable = false, columnDefinition = "BIT(1) default b'1' comment '赞赏开启'")
    private boolean appreciation;
    @Column(nullable = false, columnDefinition = "BIT(1) default b'1' comment '版权开启'")
    private boolean shareStatement;
    @Column(nullable = false, columnDefinition = "BIT(1) default b'1' comment '评论开启'")
    private boolean commentabled;
    @Column(nullable = false, columnDefinition = "BIT(1) default b'1' comment '是否发布'")
    private boolean published;
    @Column(nullable = false, columnDefinition = "BIT(1) default b'1' comment '是否推荐'")
    private boolean recommend;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updateTime;
    @ManyToOne
    private Type type;
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();
    @Transient
    private String tagIds;
    private String description;

    public void init() {
        this.tagIds = tagsToIds(this.getTags());
    }

    //1,2,3
    private String tagsToIds(List<Tag> tags) {
        if (!tags.isEmpty()) {
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for (Tag tag : tags) {
                if (flag) {
                    ids.append(",");
                } else {
                    flag = true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        } else {
            return tagIds;
        }
    }
}
