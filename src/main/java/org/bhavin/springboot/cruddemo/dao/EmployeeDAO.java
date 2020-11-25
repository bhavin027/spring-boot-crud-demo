package org.bhavin.springboot.cruddemo.dao;

import java.util.List;

import org.bhavin.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
}
