package com.springudemy.cruddemo;

import com.springudemy.cruddemo.dao.StudentDAO;
import com.springudemy.cruddemo.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.SortedMap;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	//inject the StudentDAO
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO sdao){
		return runner -> {
			//createStudent(sdao);
			createMultipleStudents(sdao);
			//readStudent(sdao);
			//findAllStudents(sdao);
			//findStudentsByLastName(sdao);
			//updateStudent(sdao);
			//deleteStudent(sdao);
			//deleteAll(sdao);
		};
	}



	private void createStudent(StudentDAO sdao) {
		//create the student object
		System.out.println("creating new Student object...");
		Student s1 = new Student("Saurabh","Jaiswal","ssj@email.com");

		//save the student object
		System.out.println("saving the new Student...");
		sdao.save(s1);

		//display the id of saved student
		System.out.println("saved student. Generated id:" + s1.getId());
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

	private void findAllStudents(StudentDAO studentDAO) {
		//get list of Students
		List<Student> stud =studentDAO.findAll();

		for(Student s : stud){
			System.out.println(s);
		}
	}

	private void findStudentsByLastName(StudentDAO sdao) {
		List<Student> stud = sdao.findByLastName("Jaiswal");
		for(Student s : stud){
			System.out.println(s);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studId= 1;
		System.out.println("getting the student with id: "+studId);

		Student st=studentDAO.findById(studId);

		System.out.println("updating the student...");

		st.setFirstName("Saurabh");
		studentDAO.update(st);

		System.out.println("updated student: "+ st);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studid=2;
		System.out.println("Deleting the Student with id: "+ studid);

		studentDAO.delete(studid);
	}

	private void deleteAll(StudentDAO studentDAO){
		System.out.println("Deleting All Students...");
		int numRowsDeleted = studentDAO.deleteAll();

		System.out.println("Deleted Count:" + numRowsDeleted);
	}

	//
}



/*
Command Line Runner: method which will be executed after
the Spring Beans have been loaded
*/
