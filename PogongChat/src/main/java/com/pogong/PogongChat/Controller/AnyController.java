package com.pogong.PogongChat.Controller;

import com.pogong.PogongChat.Common.Groups;
import com.pogong.PogongChat.Pojo.AnyObj;
import com.pogong.PogongChat.Service.AnyService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public int test_mybaits() {
        List<AnyObj> list = anyService.getAll();
        for (AnyObj obj : list) {
            System.out.println("pg see");
            System.out.println(obj);
        }

        return 1;
    }

    @PostMapping("/add_obj1")
    public int add_obj1(@Validated({Groups.addStep1.class}) @RequestBody AnyObj anyObj) {
        System.out.println("pg see add_obj1");
        System.out.println(anyObj);
        return  1;
    }

    @PostMapping("/add_obj2")
    public int add_obj2(@Validated({Groups.addStep2.class}) @RequestBody AnyObj anyObj) {
        System.out.println("pg see add_obj2");
        System.out.println(anyObj);
        return  2;
    }

    @GetMapping("/get/{id}")
    public AnyObj getOneById(@PathVariable int id) {
        System.out.println("pg see Controller getOneById");
        return anyService.getOneById(id);
    }

    @GetMapping("/logicDelete/{id}")
    public int logicDelete(@PathVariable int id,@RequestParam("reason") String reason) {
        System.out.println("pg see Controller logicDelete");
        anyService.logicDelete(id,reason);
        return 1;
    }
}