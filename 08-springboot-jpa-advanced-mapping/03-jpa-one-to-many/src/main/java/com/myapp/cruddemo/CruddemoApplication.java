package com.myapp.cruddemo;

import com.myapp.cruddemo.dao.InstructorDAO;
import com.myapp.cruddemo.entity.Course;
import com.myapp.cruddemo.entity.Instructor;
import com.myapp.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
			//deleteInstructor(instructorDAO);
			//findInstructorDetail(instructorDAO);
			//deleteInstructorDetail(instructorDAO);
			//createInstructorWithCourses(instructorDAO);

			//findInstructorWithCourses(instructorDAO);
			//findCoursesForInstructor(instructorDAO);

			findInstructorWithCoursesJoinFetch(instructorDAO);

		};
	}

	private void findInstructorWithCoursesJoinFetch(InstructorDAO instructorDAO) {
		int id=1;

		//find instructor
		System.out.println("Finding Instructor with id: "+id);
		Instructor instructor= instructorDAO.findInstructorByIdJoinFetch(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("Associated Courses: " +instructor.getCourses());
	}

	private void findCoursesForInstructor(InstructorDAO instructorDAO) {
		int id=1;
		System.out.println("Finding Instructor with id:"+ id);
		Instructor instructor = instructorDAO.findInstructorById(id);
		System.out.println("Instructor: "+ instructor);

		//find courses for instructor
		System.out.println("Finding Courses fo instructor with id: " +id);

		List<Course> courses= instructorDAO.findCourseByInstructorId(id);

		//associate the objects
		instructor.setCourses(courses);

		System.out.println("the associated courses: " +instructor.getCourses());

	}

	private void findInstructorWithCourses(InstructorDAO instructorDAO) {
		int id=1;
		System.out.println("Finding Instructor with id:"+ id);
		Instructor instructor = instructorDAO.findInstructorById(id);
		System.out.println("Instructor: "+ instructor);
		System.out.println("the associated courses: " + instructor.getCourses());
		System.out.println("Done");
	}

	private void createInstructorWithCourses(InstructorDAO instructorDAO) {
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

		//create courses
		Course c1 =new Course("Air Guitar - The Ultimate Guide");
		Course c2 =new Course("PinBall Master class - The Ultimate Guide");

		// add courses to instructor
		i.add(c1);
		i.add(c2);

		// save the instructor
		// this will also save the details object
		//bcoz of CascadeType.PERSISt
		System.out.println("Saving Instructor" + i );
		System.out.println("The Courses: "+ i.getCourses());
		instructorDAO.save(i);
		System.out.println("Done");
	}

	private void deleteInstructorDetail(InstructorDAO instructorDAO) {
		int id =3;
		System.out.println("Deleting the Instructor Detail with id: " +id);
		instructorDAO.deleteInstructorDetailById(id);
		System.out.println("Deleted!!");
	}

	private void findInstructorDetail(InstructorDAO instructorDAO) {
		//get instructorDetail object
		int theId=2;
		InstructorDetail iDetail= instructorDAO.findInstructorDetailById(theId);

		//Print InsstructorDetail
		System.out.println("Instructor Detail: "+ iDetail);

		//print associated instructor
		System.out.println("the Associated instructor: " + iDetail.getInstructor());

		System.out.println("Done!!!");
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
