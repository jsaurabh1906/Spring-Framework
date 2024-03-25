package com.myapp.cruddemo;

import com.myapp.cruddemo.dao.InstructorDAO;
import com.myapp.cruddemo.entity.*;
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
				//createCourseAndStudents(instructorDAO);
				//findCourseAndStudents(instructorDAO);
				//findStudentandCourses(instructorDAO);
				//addMoreCoursesForStudent(instructorDAO);

				//deleteCourse(instructorDAO);
				deleteStudent(instructorDAO);

		};
	}

	private void deleteStudent(InstructorDAO instructorDAO) {
		int id = 3;
		System.out.println("deleting the student with id: "+id);

		instructorDAO.deleteStudentByid(id);
		System.out.println("student deleted");
	}

	private void addMoreCoursesForStudent(InstructorDAO instructorDAO) {
		int id = 2;
		Student s = instructorDAO.findStudentAndCoursesByStudentId(id);

		//create more courses
		Course c1 = new Course("Devops : Beginners Guide");
		Course c2 = new Course("Microservices with Nodejs : Ultimate Guide");

		//add courses to student
		s.addCourse(c1);
		s.addCourse(c2);

		//update
		System.out.println("updating Student: "+ s);
		System.out.println("associated courses: "+ s.getCourses());

		instructorDAO.update(s);

		System.out.println("Student and Courses updated");

	}

	private void findStudentandCourses(InstructorDAO instructorDAO) {
			int id = 2;
			Student student = instructorDAO.findStudentAndCoursesByStudentId(id);

			System.out.println("Loaded Student: "+ student);
			System.out.println("Associated Courses: "+ student.getCourses());
	}

	private void findCourseAndStudents(InstructorDAO instructorDAO) {
			int id = 10;
			Course course = instructorDAO.findCourseAndStudentsByCourseId(id);
			System.out.println("Found Course: "+ course);
			System.out.println("Students: "+ course.getStudents());

	}

	private void createCourseAndStudents(InstructorDAO instructorDAO) {
		//create a course
		Course newCourse = new Course("React and Java - The Complete Guide");

		// create students
		Student student1 =  new Student("Saurabh","Jaiswal","ssj@gmail.com");
		Student student2 =  new Student("Aditya","Kulkarni","ak@gmail.com");
		Student student3 =  new Student("Raj","Kumar","rk@gmail.com");

		//add students to course
		newCourse.addStudent(student1);
		newCourse.addStudent(student2);
		newCourse.addStudent(student3);

		//save the course and associated students
		System.out.println("Saving course: " + newCourse);
		System.out.println("Associated Students: "+ newCourse.getStudents());

		instructorDAO.save(newCourse);
		System.out.println("Saved!!");
	}

	private void deleteCourseAndReviews(InstructorDAO instructorDAO) {
			int id = 10;
			System.out.println("Deleting the course with id: "+id);

			instructorDAO.deleteCourseById(id);

			System.out.println("Deleted both course and associated reviews");
	}

	private void findCourseAndReviews(InstructorDAO instructorDAO) {
		//get the course and reviews
		int id = 10;
		Course course = instructorDAO.findCourseAndReviewsByCourseId(id);
		//print the course
		System.out.println("Course: " + course);
		//print the reviews
		System.out.println("Reviews: " +course.getReviews());
		System.out.println("done!!");
	}

	private void createCourseAndReviews(InstructorDAO instructorDAO) {
		// create course
		Course newCourse = new Course("React - The Ultimate Guide");

		// add reviews
		newCourse.addReview(new Review("Great Course... Loved it!"));
		newCourse.addReview(new Review("Cool Course... In-depth Knowledge of each topic!"));
		newCourse.addReview(new Review("What a dumb course"));


		//save course
		System.out.println("Saving the course");
		System.out.println(newCourse);
		System.out.println(newCourse.getReviews());

		instructorDAO.save(newCourse);
	}

	private void deleteCourse(InstructorDAO instructorDAO) {
		int id = 10;
		System.out.println("deleting the course with id: "+id);

		instructorDAO.deleteCourseById(id);
		System.out.println("course deleted");
	}

	private void updateCourse(InstructorDAO instructorDAO) {
		int id = 10;
		System.out.println("Finding Course with id: " + id );
		Course courseToUpdate = instructorDAO.findCourseById(id);
		System.out.println("Course to update: "+ courseToUpdate);
		System.out.println("updating the course with id: "+ id);
		courseToUpdate.setTitle("Enjoy the simpple things");

		instructorDAO.update(courseToUpdate);
		System.out.println("course updated!!!");

	}

	private void updateInstructor(InstructorDAO instructorDAO){

		int id = 1;
		// find instructor
		Instructor i = instructorDAO.findInstructorById(id);

		//update the instructor
		System.out.println("updating the instructor with id: "+ id);
		i.setFirstName("Saurabh");
		instructorDAO.update(i);
		System.out.println("instructor updated!!!");

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



/*
* findInstructorWithCourses(instructorDAO);
* default fetchType = lazy; for onetomany on courses in Instructor class
* this method will throw lazyinitialization exception
* as the courses are of lazy fetch type and also the hibernate session closes
* so 1 solutioin is to change the fetch type to eager which will fetch courses while fetching instructor
*
*
* ************************************************************************
* another solution is write a separate method to fetch courses : findCoursesForInstructor(instructorDAO);
*  which then calls a method from dao
* Instructor instructor = instructorDAO.findInstructorById(id);
* List<Course> courses= instructorDAO.findCourseByInstructorId(id);
*
* in this still we have to write an extra queery to fetch courses
*
* ****************************************************************************
*
* another solution is using Join fetch with following steps
* take a look at findInstructorByIdJoinFetch from dao impl
* we have used the join in query
* so Join Fetch works similar to Eager loading
*
* and then in this main app we use the same dao method in findInstructorWithCoursesJoinFetch(instructorDAO);
*
 */