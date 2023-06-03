package com.myapp.springboot.cruddemo.dao;

import com.myapp.springboot.cruddemo.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


//to use /members instead of /employees
//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //no need of any code
}
