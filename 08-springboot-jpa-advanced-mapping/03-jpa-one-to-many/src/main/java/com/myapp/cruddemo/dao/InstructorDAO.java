package com.myapp.cruddemo.dao;

import com.myapp.cruddemo.entity.Course;
import com.myapp.cruddemo.entity.Instructor;
import com.myapp.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface InstructorDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCourseByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);
}
