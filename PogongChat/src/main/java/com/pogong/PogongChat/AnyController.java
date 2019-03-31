package com.pogong.PogongChat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sayHelloWorld")
public class AnyController {

    private static final Log log = LogFactory.getLog(AnyController.class);

    @GetMapping
    public Map<String,Object> sayHelloWorld(){

        if (log.isTraceEnabled()){
            log.trace("sayHelloWorld 被调用了");
        }

        System.out.println("System print hello world!");
        Map<String,Object> result = new HashMap<>();
        result.put("pg_key1111","pg_value1111");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016,Calendar.OCTOBER,2,0,0);
        result.put("pg_key2",calendar.getTime());
        return result;
    }

}
