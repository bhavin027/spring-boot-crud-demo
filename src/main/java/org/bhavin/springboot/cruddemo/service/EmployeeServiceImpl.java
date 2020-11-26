package org.bhavin.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.bhavin.springboot.cruddemo.dao.EmployeeRepository;
import org.bhavin.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	/* private EmployeeDAO employeeDAO; */
	
	/*
	 * @Autowired public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl")
	 * EmployeeDAO theEmployeeDAO) { employeeDAO = theEmployeeDAO; }
	 */
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee=null;
		
		if(result.isPresent()) {
			theEmployee = result.get();
		}else {
			throw new RuntimeException("Employee ID Not Found: "+theId);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
