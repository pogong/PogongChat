package com.pogong.PogongChat.Service;

import com.pogong.PogongChat.Common.ExecuteResult;
import com.pogong.PogongChat.Dao.RelationshipDao;
import com.pogong.PogongChat.Pojo.Relationship;
import com.pogong.PogongChat.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RelationshipService {

    @Autowired
    RelationshipDao relationshipDao;

    public ExecuteResult applyAddFriend(Integer user_id,Integer friend_id,String request_message) {
        System.out.println("RelationshipService applyAddFriend");
        ExecuteResult er = new ExecuteResult();

        Relationship relationship = new Relationship();
        relationship.setUser_id(user_id);
        relationship.setFriend_id(friend_id);
        relationship.setRequest_message(request_message);
        Integer relationshipID = relationshipDao.applyAddFriend(relationship);

        er.setCode(0);

        Map<String,Integer> info = new HashMap<>();
        info.put("relationship_id",relationship.getId());
        er.setInfo(info);

        return er;
    }

    public ExecuteResult agreeAddFriend(Integer relationship_id) {
        System.out.println("RelationshipService agreeAddFriend");
        ExecuteResult er = new ExecuteResult();
        relationshipDao.agreeAddFriend(relationship_id);
        er.setCode(0);
        //
        Relationship relationship = this.getRelationship(relationship_id);
        this.addFriendRecord(relationship.getUser_id(),relationship.getFriend_id());
        this.addFriendRecord(relationship.getFriend_id(),relationship.getUser_id());
        //
        return er;
    }

    public Relationship getRelationship(Integer relationship_id) {
        return relationshipDao.getRelationship(relationship_id);
    }

    public ExecuteResult addFriendRecord(Integer user_id,Integer friend_id) {
        System.out.println("RelationshipService addFriendRecord");
        ExecuteResult er = new ExecuteResult();
        relationshipDao.addFriendRecord(user_id,friend_id);
        er.setCode(0);
        return er;
    }

    public ExecuteResult deleteFriend(Integer user_id,Integer friend_id) {
        System.out.println("RelationshipService deleteFriend>"+user_id+"^"+friend_id);
        ExecuteResult er = new ExecuteResult();
        //
        relationshipDao.deleteFriend(user_id,friend_id);
        relationshipDao.deleteFriend(friend_id,user_id);
        //
        er.setCode(0);
        return er;
    }

    public ExecuteResult getFriendList(Integer user_id){
        System.out.println("RelationshipService getFriendList>"+user_id);
        ExecuteResult er = new ExecuteResult();
        List<Integer> list = relationshipDao.getFriendList(user_id);
        Map<String,List> info = new HashMap<>();
        info.put("list",list);
        er.setInfo(info);
        er.setCode(0);
        return er;
    }
}
