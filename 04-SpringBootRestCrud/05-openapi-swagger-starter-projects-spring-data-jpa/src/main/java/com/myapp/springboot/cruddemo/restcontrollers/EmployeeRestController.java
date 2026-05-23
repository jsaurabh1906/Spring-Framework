package com.myapp.springboot.cruddemo.restcontrollers;

import com.myapp.springboot.cruddemo.beans.Employee;
import com.myapp.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService= theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{eid}")
    public Employee findById(@PathVariable int eid){
        Employee emp = employeeService.findById(eid);
        if(emp==null){
            throw new RuntimeException("Employee Id Not Found : "+eid);
        }
        return emp;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee emp){
        emp.setId(0);
        Employee dbEmp = employeeService.save(emp);

        return dbEmp;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee emp){
        Employee dbEmp =employeeService.save(emp);
        return dbEmp;
    }

    @DeleteMapping("/employees/{eid}")
    public String deleteEMployee(@PathVariable int eid){
        Employee emp= employeeService.findById(eid);

        if(emp == null){
            throw new RuntimeException("Employee id not Found : "+eid);
        }
        employeeService.deleteById(eid);

        return "Deleted Employee Id: "+ eid;
    }


}
