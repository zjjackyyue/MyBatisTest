package com.zjjacky.dao;

import com.zjjacky.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Select("select * from user")
    List<User> getUsers();

    //方法存在多个参数，所有的参数前面必须加上@Param注解
    @Select("select * from user where id = #{id} and username = #{username}")
    User getUserById(@Param("id") int id,@Param("username") String username);

}