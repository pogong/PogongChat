package com.pogong.PogongChat.Controller;

import com.pogong.PogongChat.Common.ExecuteResult;
import com.pogong.PogongChat.Common.MapUtil;
import com.pogong.PogongChat.Pojo.User;
import com.pogong.PogongChat.Service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Log log = LogFactory.getLog(UserController.class);
    @Autowired UserService userService;

    @GetMapping("/register")
    public Map register(@RequestParam("name") String name,@RequestParam("password") String password,@RequestParam("gender") String gender){
        if (log.isTraceEnabled()){
            log.trace("UserController register 被调用了");
        }
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setGender(gender);
        ExecuteResult er = userService.register(user);
        if (er.getCode() < 0){
            return this.createReturnData(-1,null,er.getCode(),er.getDesc());
        }else{
            int user_id = user.getUser_id();
            System.out.println("UserController register succ and get user_id>"+user_id);
            Map data = MapUtil.objectToMap(user);
            return this.createReturnData(1,data,0,null);
        }
    }

    @GetMapping("/login")
    public Map login(@RequestParam("name") String name,@RequestParam("password") String password) {
        if (log.isTraceEnabled()){
            log.trace("UserController login 被调用了>"+name+"^"+password);
        }
        ExecuteResult er = userService.login(name,password);
        if (er.getCode() < 0){
            return this.createReturnData(-1,null,er.getCode(),er.getDesc());
        }else{
            return this.createReturnData(1,null,0,null);
        }
    }

    @GetMapping("/search")
    public Map search(@RequestParam("name") String name){
        System.out.println("UserController search >"+name);
        ExecuteResult er = userService.search(name);
        List<User> userList = (List<User>) er.getInfo().get("list");
        List<Map> returnList = new ArrayList<Map>();
        for(User user:userList){
            returnList.add(MapUtil.objectToMap(user));
        }
        Map<String,List> data =  new HashMap<>();
        data.put("list",returnList);
        return this.createReturnData(1,data,0,null);
    }

    @GetMapping("/getUserByID")
    public Map getUserByID(@RequestParam("user_id")Integer user_id) {
        if (log.isTraceEnabled()){
            log.trace("UserController getUserByID 被调用了>"+user_id);
        }
        ExecuteResult er = userService.getUserByID(user_id);
        if (er.getCode() < 0){
            return this.createReturnData(-1,null,er.getCode(),er.getDesc());
        }else{
            User user = (User) er.getInfo().get("user");
            Map<String,Map> map = new HashMap<>();
            map.put("user",MapUtil.objectToMap(user));
            return this.createReturnData(1,map,0,null);
        }
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
