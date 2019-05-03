package com.pogong.PogongChat.Dao;

import com.pogong.PogongChat.Pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    public int register(User user);
    public int getUserByName(String name);
    public int login(@Param("name")String name,@Param("password")String password);
}
