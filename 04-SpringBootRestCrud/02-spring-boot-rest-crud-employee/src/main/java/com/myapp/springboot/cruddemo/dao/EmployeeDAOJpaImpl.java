package com.myapp.springboot.cruddemo.dao;

import com.myapp.springboot.cruddemo.beans.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    //define fields for entityManager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        //create query
        TypedQuery<Employee> query =
                entityManager.createQuery("from Employee",Employee.class);

        //excecute query and get results
        List<Employee> employeeList = query.getResultList();


        //return results
        return employeeList;
    }

    @Override
    public Employee findById(int eid) {
        //get employee
        Employee emp= entityManager.find(Employee.class, eid );
        //return employee
        return emp;
    }

    @Override
    public Employee save(Employee theEmployee) {
        //save employee
        Employee dbEmp = entityManager.merge(theEmployee);

        //return emp
        return dbEmp;
    }

    @Override
    public void deleteById(int eid) {
        // find employee by id
        Employee emp =entityManager.find(Employee.class, eid);

        // remove employee
        entityManager.remove(emp);


    }
}
