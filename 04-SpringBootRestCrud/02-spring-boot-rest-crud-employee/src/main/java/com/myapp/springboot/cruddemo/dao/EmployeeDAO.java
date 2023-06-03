package com.myapp.springboot.cruddemo.dao;

import com.myapp.springboot.cruddemo.beans.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int eid);

    Employee save(Employee theEmployee);

    void deleteById(int eid);
}
