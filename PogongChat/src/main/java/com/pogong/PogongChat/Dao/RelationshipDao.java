package com.pogong.PogongChat.Dao;

import com.pogong.PogongChat.Pojo.Relationship;
import com.pogong.PogongChat.Pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RelationshipDao {
    public Integer applyAddFriend(Relationship relationship);
    public Integer agreeAddFriend(Integer relationship_id);
    public Integer addFriendRecord(@Param("user_id")Integer user_id,@Param("friend_id")Integer friend_id);
    public Relationship getRelationship(Integer relationship_id);
    public List<Integer> getFriendList(Integer user_id);
    public int deleteFriend(@Param("user_id")Integer user_id,@Param("friend_id")Integer friend_id);
}
