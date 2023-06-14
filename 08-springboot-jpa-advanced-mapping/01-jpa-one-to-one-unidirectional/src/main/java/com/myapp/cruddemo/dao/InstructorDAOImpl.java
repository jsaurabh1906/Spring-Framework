package com.myapp.cruddemo.dao;

import com.myapp.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class InstructorDAOImpl implements InstructorDAO{
    private EntityManager entityManager;

    @Autowired
    public InstructorDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional    //used as we are persisting the entity from db
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);

    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        //firstly retrive the instructor
        Instructor instructor=entityManager.find(Instructor.class, theId);

        //delete the instructor
        entityManager.remove(instructor);
    }
}
