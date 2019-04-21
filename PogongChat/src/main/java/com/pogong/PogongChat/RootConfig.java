package com.pogong.PogongChat;

import com.pogong.PogongChat.Dao.AnyDao;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@MapperScan(basePackageClasses = {AnyDao.class})
@EnableTransactionManagement
public class RootConfig {

    //pg point1>数据库连接配置(读取的数据在application.yml内)
    @Value(value = "${jdbc.driver-class-name}")
    private String driver;
    @Value(value = "${jdbc.url}")
    private String url;
    @Value(value = "${jdbc.username}")
    private String userName;
    @Value(value = "${jdbc.password}")
    private String password;

    @Bean
    public DataSource getDataSource() {
        DataSource dataSource = new DriverManagerDataSource();
        ((DriverManagerDataSource) dataSource).setDriverClassName(driver);
        ((DriverManagerDataSource) dataSource).setUrl(url);
        ((DriverManagerDataSource) dataSource).setUsername(userName);
        ((DriverManagerDataSource) dataSource).setPassword(password);
        return dataSource;
    }

    //pg point2>Dao映射配置(读取的数据在有mybatis-config.xml内)
    @Value(value = "classpath:mybaits-config.xml")
    private Resource configLocation;

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setConfigLocation(configLocation);
        ssfb.setDataSource(getDataSource());
        return ssfb;
    }

    //pg point3>[getDataSource方法]和[sqlSessionFactory方法]启动时会被调用一回,后面就不再会被调用
}
