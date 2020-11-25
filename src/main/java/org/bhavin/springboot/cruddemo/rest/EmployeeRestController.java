package org.bhavin.springboot.cruddemo.rest;

import java.util.List;

import org.bhavin.springboot.cruddemo.dao.EmployeeDAO;
import org.bhavin.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeDAO employeeDAO;
	
	// inject employee dao
	@Autowired
	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}
	
	// Return list of employees
	@GetMapping("/employees")
	public List<Employee> showAll() {
		return employeeDAO.findAll();
	}
	
}
