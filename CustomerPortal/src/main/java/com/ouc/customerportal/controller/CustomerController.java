package com.ouc.customerportal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ouc.customerportal.model.Customer;
import com.ouc.customerportal.model.CustomerLogin;
import com.ouc.customerportal.service.CustomerService;

@Controller
@SessionAttributes("customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model ) {		
		if(result.hasErrors()) {			
			return "signup";
		} else if(customerService.findByUserName(customer.getUserName())) {			
			model.addAttribute("message", "User Name exists. Try another user name");			
			return "signup";
		} else {			
			customerService.saveCustomer(customer);			
			model.addAttribute("message", "Saved customer details");
			return "redirect:login.html";
		}		
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(Model model) {		
		model.addAttribute("customer", new Customer());		
		return "signup";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("customerLogin") CustomerLogin customerLogin, BindingResult result) {
		System.out.println("IAM IN");
		if(result.hasErrors()) {
			return "login";			
		} else {
			boolean found=customerService.findByLogin(customerLogin.getUserName(), customerLogin.getPassword());
			if (found) {
				return "success";
			} else {
				return "failure";
			}
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("customerLogin", new Customer());
		return "login";
	}
	
	

}
