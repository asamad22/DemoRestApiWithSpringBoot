package com.example.springbootrestapi.controller;

import com.example.springbootrestapi.exception.ResourceNotFoundException;
import com.example.springbootrestapi.model.Employee;
import com.example.springbootrestapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/get")
    public List<Employee>getAll(){
        return employeeRepository.findAll();
    }

    //build creat employee Rest Api
    @PostMapping("/add")
    public Employee creatEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //build get employee by id Rest Api
    @GetMapping("/get{id}")
    public ResponseEntity<Employee>getEmployeeById(@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:"+id));
        return ResponseEntity.ok(employee);
    }

    //build update employee by id Rest Api
    @PutMapping("/update{id}")
    public ResponseEntity<Employee>updateEmployee(@PathVariable long id,@RequestBody Employee employee){
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:"+id));

        updateEmployee.setFirstName(employee.getFirstName());
        updateEmployee.setLastName(employee.getLastName());
        updateEmployee.setEmail(employee.getEmail());

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    //build delete employee by id Rest Api
    @DeleteMapping("/delete{id}")
    public ResponseEntity<HttpStatus>deleteEmployee(@PathVariable long id){
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:"+id));
        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
