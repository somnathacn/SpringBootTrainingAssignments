package com.conferencedemo.controller;

import java.util.List;
import java.util.Optional;

//import com.conferencedemo.dao.EmployeeDAO;
import com.conferencedemo.model.Employee;
import com.conferencedemo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

//	@Autowired
//	private EmployeeDAO employeeDAO;

	@Autowired
	private EmployeeService employeeservice;
	
	@Value("${message:Hello}")
	private String message;
	
	@RequestMapping("/")
	public String welcome() {
		return this.message;
	}

	@RequestMapping(value = "listEmployeesMDB", method = RequestMethod.GET)
	public List<Employee> ListEmployees(){
		return employeeservice.findAllMongoDB();
	}
	
	@RequestMapping(value = "employeeMDB/{empNo}", method = RequestMethod.GET)
	public Optional<Employee> findByEmpNoMongoDB(@PathVariable("empNo") String empNo){
		return employeeservice.findByEmpNoMongoDB(empNo);
	}
	
	@RequestMapping(value = "deleteEmployeeMDB/{empNo}", method = RequestMethod.DELETE)
	public String deleteByEmpNoMongoDB(@PathVariable("empNo") String empNo){
		employeeservice.deleteByEmpNoMongoDB(empNo);
		return "Employee Deleted " + empNo;
	}
	
	@RequestMapping(value = "updateEmployeeMDB", method = RequestMethod.PUT)
	public void updateEmployeeMongoDB(@RequestBody Employee emp) {
		System.out.println("(Service Side) Editing employee: " + emp.getEmpNo());
		employeeservice.updateEmployeeMongoDB(emp);
	}
	
	@RequestMapping(value = "updateEmployeeMDBByPost", method = RequestMethod.POST)
	public void updateEmployeeMongoDBByPost(@RequestBody Employee emp) {
		System.out.println("(Service Side) Editing employee: " + emp.getEmpNo());
		employeeservice.updateEmployeeMongoDB(emp);
	}
	
	@RequestMapping(value = "updateEmployeeMDBByPostForEntity", method = RequestMethod.POST)
	public void updateEmployeeMongoDBByPostForEntity(@RequestBody Employee emp) {
		System.out.println("(Service Side) Editing employee: " + emp.getEmpNo());
		employeeservice.updateEmployeeMongoDBByPostForEntity(emp);
	}
	
//	// URL - http://localhost:8080/employees
//	@RequestMapping(value = "/employees", //
//			method = RequestMethod.GET, //
//			produces = { MediaType.APPLICATION_JSON_VALUE })
//	public List<Employee> getEmployees() {
//		List<Employee> list = employeeDAO.getAllEmployees();
//		return list;
//	}
//
//	// URL - http://localhost:8080/employee/{empNo}
//	@RequestMapping(value = "/employee/{empNo}", //
//			method = RequestMethod.GET, //
//			produces = { MediaType.APPLICATION_JSON_VALUE })
//	public Employee getEmployee(@PathVariable("empNo") String empNo) {
//		return employeeDAO.getEmployee(empNo);
//	}
//	
//	// URL - http://localhost:8080/employee
//    @RequestMapping(value = "/employee", //
//            method = RequestMethod.PUT, //
//            produces = { MediaType.APPLICATION_JSON_VALUE })
//    //@ResponseBody
//    public Employee updateEmployee(@RequestBody Employee emp) {
//        System.out.println("(Service Side) Editing employee: " + emp.getEmpNo());
//        return employeeDAO.updateEmployee(emp);
//    }
//    
//    // URL - http://localhost:8080/deleteemployee/{empNo}
//	@RequestMapping(value = "/deleteemployee/{empNo}", //
//			method = RequestMethod.POST, //
//			produces = { MediaType.APPLICATION_JSON_VALUE })
//	public String deleteEmployee(@PathVariable("empNo") String empNo) {
//		employeeDAO.deleteEmployee(empNo);
//		return "Employee Deleted";
//	}
}