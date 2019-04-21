package com.pogong.PogongChat.Service;


import com.pogong.PogongChat.Dao.AnyDao;
import com.pogong.PogongChat.Pojo.AnyObj;
import org.springframework.beans.factory.annotation.Autowired;
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
}
