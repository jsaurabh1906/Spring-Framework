package com.myapp.springboot.cruddemo.restcontrollers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.springboot.cruddemo.beans.Employee;
import com.myapp.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;
    private final ObjectMapper objectMapper;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService, ObjectMapper theObjectMapper) {
        employeeService = theEmployeeService;
        objectMapper = theObjectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{eid}")
    public Employee findById(@PathVariable int eid) {
        Employee emp = employeeService.findById(eid);
        if (emp == null) {
            throw new RuntimeException("Employee Id Not Found : " + eid);
        }
        return emp;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee emp) {
        emp.setId(0);
        Employee dbEmp = employeeService.save(emp);

        return dbEmp;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee emp) {
        Employee dbEmp = employeeService.save(emp);
        return dbEmp;
    }

    // Add mapping for PATCH
    @PatchMapping("/employees/{eid}")
    public Employee patchEmployee(@PathVariable int eid, @RequestBody Map<String, Object> patchPayload)  {
        Employee emp = employeeService.findById(eid);

        // throw exception if null
        if (emp == null) {
            throw new RuntimeException("Employee Id Not Found : " + eid);
        }

        // throw exception if request body contains id
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Employee id is not allowed in request body : " + eid);
        }

        try {
            // convert map to JsonNode and apply updates onto existing employee
            JsonNode patchNode = objectMapper.valueToTree(patchPayload);
            // readerForUpdating will update the existing emp instance
            objectMapper.readerForUpdating(emp).readValue(patchNode);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to apply patch to Employee id: " + eid, ex);
        }

        Employee dbEmp = employeeService.save(emp);

        return dbEmp;
    }

    @DeleteMapping("/employees/{eid}")
    public String deleteEMployee(@PathVariable int eid) {
        Employee emp = employeeService.findById(eid);

        if (emp == null) {
            throw new RuntimeException("Employee id not Found : " + eid);
        }
        employeeService.deleteById(eid);

        return "Deleted Employee Id: " + eid;
    }


}
