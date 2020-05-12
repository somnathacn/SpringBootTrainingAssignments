package com.example.consumerest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumerest.model.Employee;
import com.example.consumerest.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "employees",method = RequestMethod.GET)   // or use @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
	
	@RequestMapping(value = "add",method = RequestMethod.POST) 
    public @ResponseBody ResponseEntity<?> addEmployeeByPost(@RequestBody Employee emp) {
		
        return employeeService.addEmployeeByPost(emp);
        

    }
	
	@RequestMapping(value = "addForEntity",method = RequestMethod.POST) 
    public @ResponseBody ResponseEntity<?> addEmployeeByPostForEntity(@RequestBody Employee emp) {
		
        return employeeService.addEmployeeByPostForEntity(emp);
        

    }

}
