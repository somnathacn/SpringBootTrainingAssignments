package com.conferencedemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conferencedemo.model.Employee;
import com.conferencedemo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAllMongoDB() {
		return employeeRepository.findAll();
	}
	
	@Override
	public Optional<Employee> findByEmpNoMongoDB(String empNo) {
		return employeeRepository.findById(empNo);
	}
	
	@Override
	public void deleteByEmpNoMongoDB(String empNo) {
		employeeRepository.deleteById(empNo);
	}
	
	@Override
	public void updateEmployeeMongoDB(Employee emp) {
		employeeRepository.save(emp);
	}
	
	@Override
	public void updateEmployeeMongoDBByPost(Employee emp) {
		employeeRepository.save(emp);
	}
	
	@Override
	public void updateEmployeeMongoDBByPostForEntity(Employee emp) {
		employeeRepository.save(emp);
	}
	
	
}
