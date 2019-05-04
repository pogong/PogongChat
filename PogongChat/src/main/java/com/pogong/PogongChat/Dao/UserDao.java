package com.pogong.PogongChat.Dao;

import com.pogong.PogongChat.Pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public int register(User user);
    public int getUserByName(String name);
    public int login(@Param("name")String name,@Param("password")String password);
    public List<User> search(String name);
    public User getUserByID(Integer user_id);
}
