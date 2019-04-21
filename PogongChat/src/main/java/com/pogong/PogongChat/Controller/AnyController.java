package com.pogong.PogongChat.Controller;

import com.pogong.PogongChat.Pojo.AnyObj;
import com.pogong.PogongChat.Service.AnyService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@RestController
@RequestMapping("/any")
public class AnyController {

    private static final Log log = LogFactory.getLog(AnyController.class);

    @GetMapping("/sayHelloWorld")
    public Map<String,Object> sayHelloWorld(){

        if (log.isTraceEnabled()){
            log.trace("sayHelloWorld 被调用了");
        }

        System.out.println("System print hello world!");
        Map<String,Object> result = new HashMap<>();
        result.put("pg_key1111","pg_value1111");
        return result;
    }

    @Autowired
    AnyService anyService;

    @GetMapping("/test_mybaits")
    public List<AnyObj> test_mybaits() {
        List<AnyObj> list = anyService.getAll();
        for (AnyObj obj : list) {
            System.out.println("pg see");
            System.out.println(obj);
        }

        return list;
    }

}