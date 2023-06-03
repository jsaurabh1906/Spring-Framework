package com.myapp.springbootrestdemo.restcontroller;

import com.myapp.springbootrestdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student>  slist;

    //define @PostConstruct to load the students data once..

    @PostConstruct
    public void loadData(){
        slist= new ArrayList<>();

        slist.add(new Student("Saurabh","Jaiswal"));
        slist.add(new Student("Aditya","Kulkarni"));
        slist.add(new Student("Vivek","Kumar"));
        slist.add(new Student("Harshal","Kumar"));
    }
    @GetMapping("/students")
    public List<Student> getStudent(){
        return slist;
    }
    @GetMapping("/students/{sid}")
    public Student getStudentById(@PathVariable int sid){

        if (sid> slist.size() || sid < 0){
            throw new StudentNotFoundException("Student Id Not Found" + sid);
        }

        return slist.get(sid);
    }


}
