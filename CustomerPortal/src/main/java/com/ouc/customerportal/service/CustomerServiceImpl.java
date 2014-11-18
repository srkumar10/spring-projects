package com.ouc.customerportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ouc.customerportal.dao.CustomerDAO;
import com.ouc.customerportal.model.Customer;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDAO custDAO;

	public CustomerServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public void setCustDAO(CustomerDAO custDAO) {
		this.custDAO = custDAO;
	}



	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		custDAO.save(customer);
	}

	@Override
	@Transactional
	public boolean findByLogin(String userName, String password) {
		Customer cust = custDAO.findByLogin(userName, password);
		if(cust != null && cust.getPassword().equals(password)) {
			return true;
		}
		
		return false;
	}

	@Override
	@Transactional
	public boolean findByUserName(String userName) {
		Customer cust = custDAO.findByUserName(userName);
		if(cust != null) {			
			return true;
		}
		return false;
	}
	

	@Override
	@Transactional
	public List<Customer> findAllCustomers() {
		List<Customer> customers = custDAO.findAll();
		return customers;
	}

}
