package org.bhavin.springboot.cruddemo.rest;

import java.util.List;

//import org.bhavin.springboot.cruddemo.dao.EmployeeDAO;
import org.bhavin.springboot.cruddemo.entity.Employee;
import org.bhavin.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	// inject employee dao
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	// Return list of employees
	@GetMapping("/employees")
	public List<Employee> showAll() {
		return employeeService.findAll();
	}
	
	// Return single employee
	@GetMapping("/employees/{employeeId}")
	public Employee findEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Employee ID Not Found: "+employeeId);
		}
		
		return theEmployee;
	}
	
	// Add new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		// force a save employee by passing id as 0
		theEmployee.setId(0);
		
		employeeService.save(theEmployee);
		
		return theEmployee;
		
	}
	
	// update an employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.save(theEmployee);
		
		return theEmployee;
		
	}
	
	// Delete an employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Employee ID Not Found: "+employeeId);
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted Employee Id: "+employeeId;
	}
	
}











