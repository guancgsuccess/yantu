package com.crazylemon.yantu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
@MapperScan("com.crazylemon.yantu.mapper")
@ServletComponentScan
public class YantuApplication {
	public static void main(String[] args) {
		SpringApplication.run(YantuApplication.class, args);
	}
}
