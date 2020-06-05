package com.ruge.ruge_blog_semantic.domain.vo;

import lombok.Data;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName BlogQuery
 * @date 2020.06.04 16:42
 */
@Data
public class BlogQuery {
    private String title;
    private Long typeId;
    private boolean recommend;
}
