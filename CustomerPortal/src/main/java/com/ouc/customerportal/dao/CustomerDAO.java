package com.ouc.customerportal.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ouc.customerportal.model.Customer;

public interface CustomerDAO {
	
	Customer findByLogin(String userName, String password) throws DataAccessException;
	Customer findByUserName(String userName) throws DataAccessException;
	List<Customer> findAll() throws DataAccessException;
	void save(Customer customer) throws DataAccessException;

}
