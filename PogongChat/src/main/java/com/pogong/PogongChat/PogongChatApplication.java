package com.pogong.PogongChat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pogong.PogongChat.Dao")
public class PogongChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(PogongChatApplication.class, args);
	}

}
