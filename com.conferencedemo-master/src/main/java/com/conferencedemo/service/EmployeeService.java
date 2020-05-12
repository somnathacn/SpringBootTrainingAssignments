package com.conferencedemo.service;

import java.util.List;
import java.util.Optional;

import com.conferencedemo.model.Employee;

public interface EmployeeService {
	List<Employee> findAllMongoDB();

	Optional<Employee>  findByEmpNoMongoDB(String empNo);
	
	void deleteByEmpNoMongoDB(String empNo);

	void updateEmployeeMongoDB(Employee emp);
	
	void updateEmployeeMongoDBByPost(Employee emp);

	void updateEmployeeMongoDBByPostForEntity(Employee emp);
}
