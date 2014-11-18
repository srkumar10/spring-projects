package com.ouc.customerportal.service;


import java.util.List;

import com.ouc.customerportal.model.Customer;


public interface CustomerService {	
	
	void saveCustomer(Customer customer);
	boolean findByLogin(String userName, String password);
	boolean findByUserName(String userName);
	List<Customer> findAllCustomers();
}
