package com.pogong.PogongChat.Service;

import com.pogong.PogongChat.Common.ExecuteResult;
import com.pogong.PogongChat.Dao.UserDao;
import com.pogong.PogongChat.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public ExecuteResult register(User user){
        System.out.println("UserService register case1");
        ExecuteResult er = new ExecuteResult();
        if (userDao.getUserByName(user.getName()) > 0){
            er.setCode(-1);
            er.setDesc("db has same name user,please change your name and register again");
            System.out.println(er.getDesc());
            return er;
        }
        System.out.println("UserService register case2");
        userDao.register(user);
        er.setCode(0);
        return er;
    }

    public ExecuteResult login(String name,String password) {
        ExecuteResult er = new ExecuteResult();
        int result = userDao.login(name,password);
        if (result >= 1){
            er.setCode(0);
        }else{
            er.setCode(-1);
        }
        return er;
    }
}
