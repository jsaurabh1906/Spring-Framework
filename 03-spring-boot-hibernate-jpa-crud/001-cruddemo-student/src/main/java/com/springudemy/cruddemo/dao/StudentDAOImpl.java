package com.springudemy.cruddemo.dao;

import com.springudemy.cruddemo.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{


    //field for entity manager
    private EntityManager entityManager;

    //inject entity manager using CI
    @Autowired
    StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {                               // jpa entities and not db table column names
        TypedQuery<Student> thequery =
                entityManager.createQuery("from Student order by lastName desc",Student.class);
        return thequery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> thequery =
                entityManager.createQuery("from Student where lastName=:theData ",Student.class);
        //JPQL Named Parameters are prefixed with a colon :  here ex: :theData

        //set the query parameters
        thequery.setParameter("theData", lastName);

        //return query results
        return thequery.getResultList();
    }

    @Override
    @Transactional //needed whenever we modify the db
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student st = entityManager.find(Student.class,id);
        entityManager.remove(st);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int deleteCount =  entityManager.createQuery("Delete from Student").executeUpdate();
        return deleteCount;
    }
}


/*
* @Repository:
*       Annotation for repositories
*       supports component scanning
*       translate jdbc exceptions
* */