package com.pogong.PogongChat.Service;


import com.pogong.PogongChat.Dao.AnyDao;
import com.pogong.PogongChat.Pojo.AnyObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnyService {
    @Autowired
    private AnyDao anyDao;

    public List<AnyObj> getAll() {
        List<AnyObj> list = anyDao.getAll();
        return list;
    }

    //加缓存
    @Cacheable(cacheNames="AnyObj",key="#id")
    public AnyObj getOneById(int id){
        System.out.println("pg see Service getOneById");
        return anyDao.getOneById(id);
    }

    //清除缓存
    @CacheEvict(cacheNames="AnyObj",key="#id")
    public void logicDelete(int id,String reason){
        System.out.println("pg see Service logicDelete");
        anyDao.logicDelete(id,reason);
    }
}
