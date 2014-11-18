package com.ouc.customerportal.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ouc.customerportal.dao.CustomerDAO;
import com.ouc.customerportal.model.Customer;
import com.ouc.customerportal.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:testAppContext.xml" })

public class CustomerTest {
	
	@Autowired
	private CustomerService custService;
	
	@Autowired
	private CustomerDAO custDAO;

	@Before
	public void init() {
		//custService.findAllCustomers().size();	
	}
	
	@Test
	public void listCustomers() {
		List<Customer> customers = custService.findAllCustomers();		
		Assert.assertNotNull(customers);
		Assert.assertEquals(2, customers.size());
	}
	
	@Test
	public void getCustomerByUserName() {
		Customer customer = custDAO.findByUserName("ramesh");
		//System.out.println("Username is " + customer.getUserName());		
		Assert.assertEquals("Customer found", "ramesh", customer.getUserName());	
		
	}
	
	
	@Test
	public void getCustomerByLogin() {
		Customer cust = custDAO.findByLogin("srkumar10", "kumar10");
		System.out.println("My RESULT is: " + cust.toString());
		Assert.assertEquals("Customer found", "srkumar10", cust.getUserName());
	}
	

}
