package com.myappdemo.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
////explicitly list base packages to scan
//@SpringBootApplication(
//		scanBasePackages = {"com.myappdemo.springcoredemo",
//				"com.myappdemo.util"}
//)
@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
