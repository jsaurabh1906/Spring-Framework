package com.myapp.springboot.cruddemo.dao;

import com.myapp.springboot.cruddemo.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //no need of any code
}
//spring data jpa
//using JpaRepo..