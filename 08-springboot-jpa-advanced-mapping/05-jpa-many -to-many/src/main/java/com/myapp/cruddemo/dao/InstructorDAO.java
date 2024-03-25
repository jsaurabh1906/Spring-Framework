package com.myapp.cruddemo.dao;

import com.myapp.cruddemo.entity.Course;
import com.myapp.cruddemo.entity.Instructor;
import com.myapp.cruddemo.entity.InstructorDetail;
import com.myapp.cruddemo.entity.Student;

import java.util.List;

public interface InstructorDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCourseByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor instructor);

    Course findCourseById(int id);

    void update(Course course);

    void deleteCourseById(int id);

    void save(Course course);

    Course findCourseAndReviewsByCourseId(int courseId);

    Course findCourseAndStudentsByCourseId(int courseId);

    Student findStudentAndCoursesByStudentId(int studentId);

    void update(Student student);

    void deleteStudentByid(int id);
}
