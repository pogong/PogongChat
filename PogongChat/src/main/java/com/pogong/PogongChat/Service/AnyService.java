package com.pogong.PogongChat.Service;


import com.pogong.PogongChat.Dao.AnyDao;
import com.pogong.PogongChat.Pojo.AnyObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.List;

@Service
public class AnyService {
    @Autowired
    private AnyDao anyDao;

    public List<AnyObj> getAll() {
        List<AnyObj> list = anyDao.getAll();
        return list;
    }

    @Autowired RedisTemplate<?, ?> redisTemplate;

    public AnyObj getOneById(int id){
        String key = "AnyObj_"+id;
        @SuppressWarnings("unchecked")
        RedisTemplate<String, AnyObj> rt = (RedisTemplate<String, AnyObj>)redisTemplate;

        AnyObj anyObj = rt.opsForValue().get(key);//<获取缓存数据
        if(anyObj == null) {
            anyObj =  anyDao.getOneById(id);
            rt.opsForValue().set(key,anyObj);//<设置缓存数据
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MINUTE, 5);
            rt.expireAt(key, c.getTime());
            System.out.println("set data to cache");
        }else {
            System.out.println("data form cache");
        }

        return anyObj;
    }

    public void logicDelete(int id,String reason){
        System.out.println("pg see Service logicDelete");
        RedisTemplate<String, AnyObj> rt = (RedisTemplate<String, AnyObj>)redisTemplate;
        String key = "AnyObj_"+id;
        rt.delete(key);//<删除缓存
        anyDao.logicDelete(id,reason);
    }
}
