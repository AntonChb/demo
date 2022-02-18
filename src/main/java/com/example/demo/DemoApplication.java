package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	DemoApplicationService demoApplicationService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public int sum ( int one, int two){
		return one + two;
	}
	public int result ( int one, int two){
		DemoApplicationService q = new DemoApplicationService();
		return q.multiply(one, two);
	}
}