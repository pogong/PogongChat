package com.pogong.PogongChat.Controller;

import com.pogong.PogongChat.Common.ExecuteResult;
import com.pogong.PogongChat.Common.MapUtil;
import com.pogong.PogongChat.Pojo.User;
import com.pogong.PogongChat.Service.RelationshipService;
import com.pogong.PogongChat.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/relationship")
public class RelationshipController {

    @Autowired
    RelationshipService relationshipService;

    @GetMapping("/applyAddFriend")
    public Map applyAddFriend(@RequestParam("user_id") Integer user_id,@RequestParam("friend_id") Integer friend_id,@RequestParam("request_message") String request_message){
        System.out.println("RelationshipController addFriend >"+user_id + "^" + friend_id);
        ExecuteResult er = relationshipService.applyAddFriend(user_id,friend_id,request_message);
        return this.createReturnData(1,er.getInfo(),0,null);
    }

    @GetMapping("/agreeAddFriend")
    public Map agreeAddFriend(@RequestParam("relationship_id") Integer relationship_id){
        System.out.println("RelationshipController agreeAddFriend >"+relationship_id);
        ExecuteResult er = relationshipService.agreeAddFriend(relationship_id);
        return this.createReturnData(1,er.getInfo(),0,null);
    }

    @GetMapping("/getFriendList")
    public Map getFriendList(@RequestParam("user_id") Integer user_id){
        System.out.println("RelationshipController getFriendList");
        ExecuteResult er = relationshipService.getFriendList(user_id);
        return this.createReturnData(1,er.getInfo(),0,null);
    }

    @GetMapping("/deleteFriend")
    public Map deleteFriend(@RequestParam("user_id") Integer user_id,@RequestParam("friend_id") Integer friend_id){
        System.out.println("RelationshipController deleteFriend >"+user_id + "^" + friend_id);
        ExecuteResult er = relationshipService.deleteFriend(user_id,friend_id);
        return this.createReturnData(1,er.getInfo(),0,null);
    }

    public Map createReturnData(int s, Map d,int error_code,String error_desc){
        Map<String,Object> error = null;
        if (error_code != 0){
            error = new HashMap<>();
            error.put("error_code",error_code);
            error.put("error_desc",error_desc);
        }

        Map<String,Object> result = new HashMap<>();
        result.put("s",s);
        result.put("d",d);
        result.put("error",error);

        return result;
    }
}
