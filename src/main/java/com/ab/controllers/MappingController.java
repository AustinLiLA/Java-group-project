package com.ab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ab.models.Customer;
import com.ab.servicies.CustomerService;


@Controller
public class MappingController {
	
	@Autowired 
	private CustomerService customerService;
	
	
	@GetMapping("/stocks/chart")
	public String chart() {			
		return "stock_chart"; 
	}
	
	@GetMapping("/stocks/chart/{stockName}/{stockRegion}")
	public String chart(@PathVariable("stockName") String stockName,@PathVariable("stockRegion") String stockRegion) {
		
		System.out.println(stockName + ","+stockRegion);			
		return "stock_chart"; 
	}
	
	@GetMapping("/stocks/orderbook")
	public String orderbook() {
		return "order_book"; 
	}
	
	@GetMapping("/login")
	public String login() {
		return "login"; 
	}
	
	//@GetMapping("/Register")
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String showRegistrationForm (){
    	return "register";
    }
    

    
    @PostMapping("/registerCustomer")
    public String registerProcess(@ModelAttribute Customer c) {
    	
    	Customer registeredCustomer = this.customerService.registerCustomer(c);
    	if(registeredCustomer != null) {
    		
    		return "register_success";
	   }
    	else {
    		return "reg_faiure";
    	}
    }

}
