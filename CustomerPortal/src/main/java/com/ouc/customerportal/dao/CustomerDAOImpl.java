package com.ouc.customerportal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ouc.customerportal.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	protected EntityManager entityManager;
	private Customer customer = null;
	

	public CustomerDAOImpl() {
		
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Customer findByLogin(String userName, String password) throws DataAccessException {		
		
		
		Query query =  entityManager.createQuery(
							"SELECT c FROM Customer c WHERE c.userName=:user AND c.password=:pass")
							.setParameter("user", userName)
							.setParameter("pass", password);
		
		List<Customer> customerList = query.getResultList();
		if(customerList == null || customerList.size() == 0) {
			return null;
		}
				
		return (Customer)customerList.get(0);
		
	}
	
	/**
	@Override
	public Customer findByUserName(String userName) throws DataAccessException {
		
		try {
			customer =  (Customer)entityManager.createQuery(
					"SELECT c FROM Customer c WHERE c.userName = :userId")
					.setParameter("userId", userName)
					.setMaxResults(10)
					.getSingleResult();
		} catch(NoResultException nre) {
			System.out.println("No results found by using findByUserName");
			
		} catch(NonUniqueResultException nue) {
			System.out.println("Duplicate Results found");
		}
		
		return customer;
	} **/
	
	
	@SuppressWarnings("unchecked")
	public Customer findByUserName(String userName) throws DataAccessException {
		
		Query query = entityManager.createQuery(
				"SELECT c FROM Customer c WHERE c.userName = :uname")
				.setParameter("uname", userName);
		
		List<Customer> customerList = query.getResultList();
		if(customerList == null ||customerList.size() == 0) {
			return null;
		}		
		
		return (Customer)customerList.get(0);	
	}

	@Override
	public void save(Customer customer) throws DataAccessException {
		entityManager.persist(customer);
	}

	
	
	@Override
	public List<Customer> findAll() throws DataAccessException {
		String q = "SELECT c FROM Customer c";
		TypedQuery<Customer> query = entityManager.createQuery(q, Customer.class);		
		List<Customer> customerList = query.getResultList();
		return customerList;
	}

}
