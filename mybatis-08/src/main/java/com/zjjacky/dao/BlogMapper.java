package com.zjjacky.dao;

import com.zjjacky.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    int addBlog(Blog blog);

    List<Blog> findBlogByIF(Map map);

    List<Blog> findBlogByChoose(Map map);

    int updateBlog(Map map);
}
