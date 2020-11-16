package com.zjjacky.dao;

import com.zjjacky.pojo.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> getUserList();

    User getUserById(int id);

    User getUserByUsername(Map<String,Object> map);

    List<User> getUserLike(HashMap<String, Object> s);

    int addUser(User user);

    int addUser2(Map<String,Object> map);

    int updateUser(User user);

    int deleteUser(int id);
}