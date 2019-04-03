package com.pogong.PogongChat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/connectDB")
    public int connectDB(){
        String sql = "select * from tv_series";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {

            System.out.println("pg see begin");
            System.out.println(map.getClass());
            System.out.println(map);
            System.out.println("pg see end");

            Set<Map.Entry<String, Object>> entries = map.entrySet( );
            if(entries != null) {
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
                while(iterator.hasNext( )) {
                    Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
                    Object key = entry.getKey( );
                    Object value = entry.getValue();
                    System.out.println("pg see>"+key+":"+value);
                }
            }

        }
        return 1;
    }
}