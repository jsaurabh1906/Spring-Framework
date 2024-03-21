package com.myapp.springboot.thymeleafdemo.service;

import com.myapp.springboot.thymeleafdemo.bean.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee theEmployee);

    void deleteById(int theId);

}