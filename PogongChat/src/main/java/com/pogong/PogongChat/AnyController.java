package com.pogong.PogongChat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sayHelloWorld")
public class AnyController {

    @GetMapping
    public Map<String,Object> sayHelloWorld(){
        System.out.println("hello world! pg see");
        Map<String,Object> result = new HashMap<>();
        result.put("pg_key1111","pg_value1111");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016,Calendar.OCTOBER,2,0,0);
        result.put("pg_key2",calendar.getTime());
        return result;
    }

}
