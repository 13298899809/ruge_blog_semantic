package com.ruge.ruge_blog_semantic.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName TestController
 * @date 2020.06.04 10:01
 */
@RestController
public class TestController {
    @GetMapping("list")
    public Map<String, Object> list() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }
}
