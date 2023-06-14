package com.myapp.cruddemo;

import com.myapp.cruddemo.dao.InstructorDAO;
import com.myapp.cruddemo.entity.Instructor;
import com.myapp.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(InstructorDAO instructorDAO){
		return runner->{
			//createInstructor(instructorDAO);
			//findInstructor(instructorDAO);
			deleteInstructor(instructorDAO);
		};
	}

	private void deleteInstructor(InstructorDAO instructorDAO) {
		int theId = 1;
		System.out.println("Deleting the Instructor with id: "+ theId);
		instructorDAO.deleteInstructorById(theId);
		System.out.println("deleted!!!");

	}

	private void findInstructor(InstructorDAO instructorDAO) {
		//
		int theId=1;
		System.out.println("Finding instructor id:" + theId);

		Instructor i = instructorDAO.findInstructorById(theId);

		System.out.println("Instructor i : " + i);
		System.out.println("the associated instructor detail only: "+ i.getInstructorDetail());
	}

	private void createInstructor(InstructorDAO instructorDAO) {
		/*
		//create the instructor object
		Instructor i =new Instructor("Saurabh","Jaiswal","ssj@gmail.com");

		//create the instructor detail object
		InstructorDetail iDetail=new InstructorDetail("abc","instructor");

*/

		//create the instructor object
		Instructor i =new Instructor("Shubham","Jaiswal","sj@gmail.com");

		//create the instructor detail object
		InstructorDetail iDetail=new InstructorDetail("xyz","guitar");



		//associate the instructor with instructordetail
		i.setInstructorDetail(iDetail);

		// save the instructor
		// this will also save the details object
		//bcoz of CascadeType.All
		System.out.println("Saving Instructor" + i );
		instructorDAO.save(i);
		System.out.println("Done");
	}
}
