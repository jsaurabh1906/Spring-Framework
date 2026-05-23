package com.myapp.springboot.cruddemo.service;

import com.myapp.springboot.cruddemo.beans.Employee;
import com.myapp.springboot.cruddemo.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){

        employeeRepository =theEmployeeRepository;
    }


    @Override
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int eid) {
        Optional<Employee> result = employeeRepository.findById(eid);
        Employee emp = null;
        if(result.isPresent()){
            emp=result.get();
        }
        else{
            throw new RuntimeException("Did not find employee id: "+eid);
        }
        return emp;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }


    @Override
    public void deleteById(int eid) {
        employeeRepository.deleteById(eid);
    }


}

//Optional<Employee> result = employeeRepository.findById(eid);
//        OPtional is a different pattern instead of having
//        to check for nulls

//Jpa Repository provides support for @Transactioinal ,
//no need to add the same...