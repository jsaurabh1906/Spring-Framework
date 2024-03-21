package com.myapp.springboot.thmeleafdemo.controller;

import com.myapp.springboot.thmeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    //inject the list of countries from application properties
    @Value("${countries}")
    private List<String> countries;
    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showForm(Model model){

        //Create a new student obj
        Student stud = new Student();

        //add student object to the model
        model.addAttribute("student",stud);

        //add the list of countries to the model
        model.addAttribute("countries", countries);

        model.addAttribute("languages",languages);
        model.addAttribute("systems",systems);
        //return the student-form html page for this getmapping
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student stud){

        //log  the Student details collected from form
        System.out.println("Student:" + stud.getFirstName() + " " + stud.getLastName());

        return "student-confirmation";
    }
}
