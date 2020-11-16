package com.zjjacky.dao;


import com.zjjacky.pojo.Blog;
import com.zjjacky.utils.IDUtils;
import com.zjjacky.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class daoTest {

    @Test
    public void addBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();

        blog.setId(IDUtils.getId());
        blog.setTitle("Java如此简单");
        blog.setCreate_time(new Date());
        blog.setAuthor("朱家俊");
        blog.setViews(9999);
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void findBlogByIF() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title","Java如此简单");
        map.put("author","456");
        List<Blog> blogs= mapper.findBlogByIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
    }

    @Test
    public void findBlogByChoose() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title","Java如此简单");
        List<Blog> blogs= mapper.findBlogByChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
    }

    @Test
    public void updateBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title","呵呵");
        map.put("author","我擦");
        mapper.updateBlog(map);
    }
}
