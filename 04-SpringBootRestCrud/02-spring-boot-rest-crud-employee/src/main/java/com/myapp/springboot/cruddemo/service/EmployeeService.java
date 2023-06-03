package com.myapp.springboot.cruddemo.service;

import com.myapp.springboot.cruddemo.beans.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int eid);

    Employee save(Employee theEmployee);

    void deleteById(int eid);
}
