package com.myapp.hibernate.demo;

import com.myapp.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class CreateStudentImagesSetDemo {
  public static void main(String[] args) {
    //create session factory
    SessionFactory factory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Student.class)
        .buildSessionFactory();


    //create session
    Session session = factory.getCurrentSession();
    try{
      //create the objects
      Student s1 = new Student("Saurabh","Jaiswal","ssj@gmail.com");
      Set<String> images = s1.getImages();

      images.add("photo1.jpg");
      images.add("photo2.jpg");
      images.add("photo3.jpg"); //in sets , no duplicates allowed

      //start the transaction
      session.beginTransaction();

      //save the object
      System.out.println("Saving the Student and images...");
      session.persist(s1);

      //commit the transaction
      session.getTransaction().commit();
      System.out.println("Saved!!!");

    }finally {
      //clean up code
      session.close();
      factory.close();
    }



  }
}