package com.yc.sq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.yc.sn.dao")
public class GoodApp {
	
	public static void main(String[] args) {
		SpringApplication.run(GoodApp.class, args);
	}

}
