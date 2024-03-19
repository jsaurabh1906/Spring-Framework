package com.springudemy.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(){
		return runner -> {
			System.out.println("Helllllllooooo!!!!!!!");
		};
	}
}



/*
Command Line Runner: method which will be executed after
the Spring Beans have been loaded
*/
