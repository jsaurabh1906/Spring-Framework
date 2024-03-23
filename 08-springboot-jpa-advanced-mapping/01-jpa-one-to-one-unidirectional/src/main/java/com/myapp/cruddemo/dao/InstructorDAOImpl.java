package com.myapp.cruddemo.dao;

import com.myapp.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class InstructorDAOImpl implements InstructorDAO{
    private EntityManager entityManager;

    //inject entity manager using CI
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

/*
* findInstructorById method : we are fetching Instructor,
* but with that instructor details object will also be retrieved
*
* Because of default behaviour of @OneToOne fetch type is eager
*
*
* deleteInstructorById Method:
* this will also delete the instructor details object,
* bcoz of CascadeType.ALL
*
* */

