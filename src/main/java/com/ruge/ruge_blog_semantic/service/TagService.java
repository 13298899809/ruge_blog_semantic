package com.ruge.ruge_blog_semantic.service;

import com.ruge.ruge_blog_semantic.domain.entitys.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName TagService
 * @date 2020.06.04 16:35
 */
public interface TagService {

    Tag saveTag(Tag type);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTag();

    List<Tag> listTagTop(Integer size);

    List<Tag> listTag(String ids);

    void updateTag(Long id, Tag type);

    void deleteTag(Long id);
}
