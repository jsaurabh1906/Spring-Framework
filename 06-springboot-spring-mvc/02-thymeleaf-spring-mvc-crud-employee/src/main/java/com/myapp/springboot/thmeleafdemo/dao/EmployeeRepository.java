package com.myapp.springboot.thmeleafdemo.dao;

import com.myapp.springboot.thmeleafdemo.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!
    // method to sort by lastname
    public List<Employee> findAllByOrderByLastNameAsc();
}