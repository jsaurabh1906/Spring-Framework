package com.myapp.cruddemo.dao;

import com.myapp.cruddemo.entity.Course;
import com.myapp.cruddemo.entity.Instructor;
import com.myapp.cruddemo.entity.InstructorDetail;
import com.myapp.cruddemo.entity.Student;
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

   /*  when only entity is not associated with another entity means no relation

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        //firstly retrive the instructor
        Instructor instructor=entityManager.find(Instructor.class, theId);

        //delete the instructor
        entityManager.remove(instructor);
    }

    */

    // now when we have courses associated with instructor
    // we need to update this method accordingly
   @Override
   @Transactional
   public void deleteInstructorById(int theId) {
       //firstly retrive the instructor
       Instructor instructor=entityManager.find(Instructor.class, theId);

       // get the courses
       List<Course> courses = instructor.getCourses();

       //break the association of all courses for instructor
       for(Course c : courses){
           c.setInstructor(null); //removes the instructor from the courses
       }

       //delete the instructor and not the associated courses based on cascade types
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
                "select i from Instructor i " +
                    "JOIN FETCH i.courses " +
                    "JOIN FETCH i.instructorDetail " +
                    "where i.id= :data",
            Instructor.class
        );
        query.setParameter("data", theId);
        Instructor instructor = query.getSingleResult();

        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor); //merge will update the existing entity
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);

    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);

    }

  @Override
  @Transactional
  public void deleteCourseById(int id) {
     Course course = entityManager.find(Course.class,id);

     entityManager.remove(course);
  }

  @Override
  @Transactional
  public void save(Course course) {
     entityManager.persist(course); // will save course and associated reviews (as due to CascadeType.ALL)
  }

  @Override
  public Course findCourseAndReviewsByCourseId(int courseId) {

     //create query
    TypedQuery<Course> query = entityManager.createQuery(
        "select c from Course c "
          + "Join Fetch c.reviews "
          + "where c.id = :data",Course.class);
    query.setParameter("data", courseId );
    //execute query
    Course course = query.getSingleResult();
     return course;
  }

  @Override
  public Course findCourseAndStudentsByCourseId(int courseId) {
    // create query
    TypedQuery<Course> query = entityManager.createQuery(
        "select c from Course c "
            + "Join Fetch c.students "
            + "where c.id = :data",Course.class);
    query.setParameter("data", courseId );

    //execute query
    Course course = query.getSingleResult();
    return course;
  }

  @Override
  public Student findStudentAndCoursesByStudentId(int studentId) {

     TypedQuery<Student> query = entityManager.createQuery(
       "select s from Student s "
       + "Join Fetch s.courses "
       + " where s.id = :data", Student.class
     );
     query.setParameter("data", studentId);
     return  query.getSingleResult(); //return single student
  }

  @Override
  @Transactional
  public void update(Student student) {
    entityManager.merge(student);
  }

  @Override
  @Transactional
  public void deleteStudentByid(int id) {
    Student student = entityManager.find(Student.class,id);
    entityManager.remove(student);
  }
}
