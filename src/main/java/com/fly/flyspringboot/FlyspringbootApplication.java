package com.fly.flyspringboot;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan//进行扫描 servlet三大组件
@MapperScan("com.fly.flyspringboot.mapper")//指定扫描的包
public class FlyspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlyspringbootApplication.class, args);
	}

}

