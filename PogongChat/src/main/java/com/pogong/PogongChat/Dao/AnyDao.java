package com.pogong.PogongChat.Dao;

import com.pogong.PogongChat.Pojo.AnyObj;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnyDao {
    public List<AnyObj> getAll();
    public AnyObj getOneById(int id);
    public void logicDelete(@Param("id")int id, @Param("reason")String reason);
}
