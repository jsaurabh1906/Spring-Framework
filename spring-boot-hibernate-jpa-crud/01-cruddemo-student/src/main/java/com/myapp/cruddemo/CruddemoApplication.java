package com.myapp.cruddemo;


import com.myapp.cruddemo.dao.StudentDAO;
import com.myapp.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//findAllStudents(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studid=3;
		System.out.println("Deleting the Student with id: "+ studid);

		studentDAO.delete(studid);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studId= 1;
		System.out.println("getting the student with id: "+studId);

		Student st=studentDAO.findById(studId);

		System.out.println("updating the student...");

		st.setFirstName("Saurabh");
		studentDAO.update(st);

		System.out.println("updated syudent: "+ st);
	}

	private void findAllStudents(StudentDAO studentDAO) {
		//get list of Students
		List<Student> stud =studentDAO.findAll();

		for(Student s : stud){
			System.out.println(s);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student obj
		Student s1 = new Student("John", "Sharma","js@gmail.com");

		// save student
		studentDAO.save(s1);

		// displayid of the saved student
		int id= s1.getId();
		System.out.println("saved student id: "+id);

		// retrieve student based on the id
		Student st=studentDAO.findById(id);

		// display student
		System.out.println("Found: "+ st);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create multiple student object
		System.out.println("Creating New Student");
		Student s1= new Student( "Shubham", "Jaiswal", "ssj@gmail.com");
		Student s2= new Student( "Aditya", "kulkarni", "ak@gmail.com");
		Student s3= new Student( "Vivek", "kumar", "vk@gmail.com");
		//save all
		System.out.println("saving students....");
		studentDAO.save(s1);
		studentDAO.save(s2);
		studentDAO.save(s3);
	}

	private void createStudent(StudentDAO studentDAO) {
	/*	//create student object
		System.out.println("Creating New Student");
		Student s1= new Student( "Saurabh", "Jaiswal", "ssj@gmail.com");

		//save the student obj
		System.out.println("saving Student");

		studentDAO.save(s1);
		//dispaly id of saved student
		System.out.println("Saved Student id:" + s1.getId());
*/
	}

}
