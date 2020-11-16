package com.zjjacky.dao;

import com.zjjacky.pojo.User;
import com.zjjacky.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void getUsers() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();

        for(User user : userList){
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);

        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void getUserByUsername() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String,Object> map = new HashMap();
        map.put("username","老朱");
        User user = userMapper.getUserByUsername(map);

        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void getUserLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String,Object> map = new HashMap();
        map.put("username","老朱");
        List<User> userList = userMapper.getUserLike(map);

        for(User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String,Integer> map = new HashMap();
        map.put("startIndex",0);
        map.put("pageSize",3);
        List<User> userList = userMapper.getUserByLimit(map);

        for(User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.addUser(new User(3,"老朱","深圳"));

        sqlSession.commit();

        if(result > 0) {
            System.out.println(result);
        }
        sqlSession.close();
    }

    @Test
    public void addUser2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Object> map = new HashMap();
        map.put("id",3);
        map.put("username","小杜");
        map.put("password","深圳");
        int result = userMapper.addUser2(map);

        sqlSession.commit();

        if(result > 0) {
            System.out.println(result);
        }
        sqlSession.close();
    }

    @Test
    public void update() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser(new User(3,"小杜","北京"));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(3);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testLog4j() {
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }
}
