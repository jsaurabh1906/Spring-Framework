package com.myapp.springboot.thmeleafdemo.service;

import com.myapp.springboot.thmeleafdemo.bean.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee theEmployee);

    void deleteById(int theId);

}