package Emloyee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Emloyee.dto.Employee;

public class EmployeeDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("abc").createEntityManager();
		
	}

	public List<Employee> getAllEmployees() {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select e from Employee e");
		
		return query.getResultList();	
	}

	public void saveEmployee(Employee employee) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		
	}

	public void deleteEmployee(int id) {
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee=entityManager.find(Employee.class, id);
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(dbEmployee);
		entityTransaction.commit();
		
	}

	public Employee findEmployeeById(int id) {
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee=entityManager.find(Employee.class, id);
		return dbEmployee;
	}

	public void updateEmployee(Employee employee) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
	}
	

}
	
	
