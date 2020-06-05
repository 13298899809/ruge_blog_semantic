package com.ruge.ruge_blog_semantic.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName RequestLog
 * @date 2020.06.03 13:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestLog {
    private String url;
    private String ip;
    private String classMethod;
    private Object[] args;
}
