package org.bhavin.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.bhavin.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	// define field for entity manager
	private EntityManager entityManager;
	
	// setup constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	@Transactional
	public List<Employee> findAll() {

		// get current Hibernate Session
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		// execute the query and get result list
		
		List<Employee> employees = theQuery.getResultList();
		
		// return the result
		
		return employees;
	}

}










