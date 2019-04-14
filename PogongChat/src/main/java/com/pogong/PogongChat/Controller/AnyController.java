package com.pogong.PogongChat.Controller;

import com.pogong.PogongChat.Dao.AnyDao;
import com.pogong.PogongChat.Pojo.AnyObj;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
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

    private SqlSessionFactory sqlSessionFactory = null;

    @GetMapping("/test_mybaits")
    public int test_mybaits() {

//        1.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

//        2.加载SqlMapConfig.xml配置文件
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybaits-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

//        3.创建SqlSessionFactory对象
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        AnyDao anyDao = sqlSession.getMapper(AnyDao.class);
        List<AnyObj> list = anyDao.getAll();
        for (AnyObj obj : list) {
            System.out.println("pg see");
            System.out.println(obj);
        }

        return 1;
    }

}