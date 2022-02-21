package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	private static Logger logger;

	@Autowired
	DemoApplicationService demoApplicationService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		logger = LogManager.getRootLogger();
		int x = 5;
		if (x > 7) {
			System.out.println("Правильно");
		} else {
			logger.info("В параметре Х-написана хуйня");
			System.out.println("Ошибка");
		}


//	public Integer y() {
//		return DemoApplication.integer();
//	}
//
//
//	public static Integer integer() {
//		logger = LogManager.getRootLogger();
//		int x = 5;
//		if (x > 7) {
//			System.out.println("Правильно");
//		} else {
//			logger.info("В параметре Х-написана хуйня");
//			System.out.println("Ошибка");
//		}
//		return x;
//	}

	}
	public int sum(int one, int two) {
		return one + two;
	}

	public int result(int one, int two) {
		DemoApplicationService q = new DemoApplicationService();
		return q.multiply(one, two);
	}
}

