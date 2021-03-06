package com.yc.sn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.yc.sn.dao")
public class CartApp {
	
	public static void main(String[] args) {
		SpringApplication.run(CartApp.class, args);
	}

}
