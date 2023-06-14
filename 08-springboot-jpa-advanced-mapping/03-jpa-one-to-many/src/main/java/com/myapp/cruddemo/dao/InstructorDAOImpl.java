package com.myapp.cruddemo.dao;

import com.myapp.cruddemo.entity.Course;
import com.myapp.cruddemo.entity.Instructor;
import com.myapp.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
       return  entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional  //as we modifying the db
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail instructorDetail=entityManager.find(InstructorDetail.class,theId);

        //remove the associated object reference
        // break bi-diredtional

        instructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCourseByInstructorId(int theId) {

        //create query
        TypedQuery<Course>  query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", theId);

        //execute query
        List<Course> courses =query.getResultList();
        return courses;

    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i JOIN FETCH i.courses JOIN FETCH i.instructorDetail where i.id= :data",Instructor.class
        );
        query.setParameter("data", theId);
        Instructor instructor = query.getSingleResult();

        return instructor;
    }
}
