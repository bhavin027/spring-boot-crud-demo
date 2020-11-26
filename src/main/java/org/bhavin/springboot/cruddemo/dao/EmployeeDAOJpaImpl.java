package org.bhavin.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.bhavin.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		// create query
		Query theQuery = entityManager.createQuery("from Employee", Employee.class);
		
		//Execute query and get results
		List<Employee> employees = theQuery.getResultList();
		// return the result
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		//get the employee
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		// return
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		// save or update the employee
		Employee tempEmployee = entityManager.merge(theEmployee);
		
		// update with id from db
		theEmployee.setId(tempEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {
		
		// delete object with primary key
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();

	}

}
