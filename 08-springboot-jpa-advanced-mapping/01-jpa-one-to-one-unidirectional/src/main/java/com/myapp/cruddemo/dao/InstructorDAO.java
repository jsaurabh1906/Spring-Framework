package com.myapp.cruddemo.dao;

import com.myapp.cruddemo.entity.Instructor;

public interface InstructorDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
}
