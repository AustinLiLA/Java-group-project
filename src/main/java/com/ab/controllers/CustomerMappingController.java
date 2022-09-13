package com.ab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ab.models.Customer;

@Controller
public class CustomerMappingController {

	@GetMapping("/index")
	public String viewHomePage() {
		
		return "index";
	}

    @GetMapping("/registration")
  
    public String showRegistrationForm(Model model) {
    	
    	model.addAttribute("customer", new Customer());
    	
    	return "registration";
    }
    
    @GetMapping ("/login")
    
    public String login() {
    	
    	return "login";
    }
	
}
