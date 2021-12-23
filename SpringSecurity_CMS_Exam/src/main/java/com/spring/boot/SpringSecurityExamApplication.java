package com.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.boot.repository.test.ClassInfoRepository;

@SpringBootApplication
public class SpringSecurityExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityExamApplication.class, args);
		System.out.println("Hi.. Spring Security");
	}

	
}
