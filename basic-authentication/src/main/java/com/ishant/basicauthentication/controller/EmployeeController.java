package com.ishant.basicauthentication.controller;

import com.ishant.basicauthentication.model.Employee;
import com.ishant.basicauthentication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return this.employeeService.getAllEmployees();
    }

}
