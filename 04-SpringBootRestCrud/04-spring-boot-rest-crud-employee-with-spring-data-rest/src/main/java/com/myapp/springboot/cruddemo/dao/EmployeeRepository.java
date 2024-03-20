package com.myapp.springboot.cruddemo.dao;

import com.myapp.springboot.cruddemo.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //no need of any code
}
//spring data jpa
//using JpaRepo..

//localhost:8080/employees
/*
if changed properties
http://localhost:8080/magic-api/employees

*/
/* by default spring data takes the plural form of entity class
*  for ex for Employee Class ---> /employees
*
*   if we want to change this we can use @RepositoryRestResource(path="members")
*   this will change our path from /employees to /members
*
*
*   Sorting paths
*   /employees?sort=lastName,desc
*   /employees?sort=lastName,asc
*
* */