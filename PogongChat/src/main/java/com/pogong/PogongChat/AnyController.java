package com.pogong.PogongChat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sayHelloWorld")
public class AnyController {

    @GetMapping
    public Map<String,Object> sayHelloWorld(){
        System.out.println("hello world!");
        Map<String,Object> result = new HashMap<>();
        result.put("pg_key","pg_value");
        return result;
    }

}
