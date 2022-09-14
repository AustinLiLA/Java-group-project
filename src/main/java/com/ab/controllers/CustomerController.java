package com.ab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ab.models.Customer;
import com.ab.servicies.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired 
	private CustomerService customerService;
	
	
	  @PostMapping("/registerCustomer")
	    public String registerProcess(@ModelAttribute Customer c, Model model) {
	    	
	    	Customer registeredCustomer = this.customerService.registerCustomer(c);
	    	
	    	model.addAttribute("session_customer", registeredCustomer);
	    	
	    	if(registeredCustomer != null) {
	    		
	    		return "register_success";
		   }
	    	else {
	    		return "reg_faiure";
	    		
	   @PostMapping("/login")
	   
	    	}
	    }
}
