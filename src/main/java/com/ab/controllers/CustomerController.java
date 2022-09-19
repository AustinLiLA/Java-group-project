package com.ab.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ab.models.Customer;
import com.ab.servicies.CustomerService;


@SessionAttributes({"session_customer"})
@Controller
public class CustomerController {
	
	@Autowired 
	private CustomerService customerService;

	
	@ModelAttribute
	public Customer customer() {
		
		return new Customer();
	}
	
	
//	  @PostMapping("/registerCustomer")
//	    public String registerProcess(@ModelAttribute Customer c, Model model) {
//	    	
//	    	Customer registeredCustomer = customerService.registerCustomer(c);
//	    	
//	    	model.addAttribute("session_customer", registeredCustomer);
//	    	
//	    	if(registeredCustomer != null) {
//	    		
//	    		return "register_success";
//		   }
//	    	else {
//	    		return "reg_faiure";
//	    	}
//	    }
	
	  @PostMapping("/registerCustomer")
	    public String registerProcess(Customer c) {
	    	
	    	Customer registeredCustomer = customerService.registerCustomer(c);
	        	
	    	if(registeredCustomer != null) {
	    		
	    		return "login";
		   }
	    	else {
	    		return "register";
	    	}
	    }
	  
	  @PostMapping("/login")
	  public String loginProcess(@ModelAttribute Customer c, Model model) {
		  		  
		 Customer  loginCustomer = customerService.loginCustomer(c.getEmail(), c.getPassword());
		  
		  model.addAttribute("session_customer", loginCustomer);
		  
		 
		  if(loginCustomer != null) {
	    		
	    		return "stock_chart";
		   }
	    	else {
	    		return "register";
	    	}
	  }
	  
	 
	  
	  
	  
	  
	  
	  
}
