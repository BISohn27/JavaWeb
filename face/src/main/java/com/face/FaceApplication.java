package com.face;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value= {"com.face.mapper"})
public class FaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaceApplication.class, args);
	}
}
