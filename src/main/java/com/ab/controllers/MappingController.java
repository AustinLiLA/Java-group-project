package com.ab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ab.models.Customer;
import com.ab.models.Stock;
import com.ab.servicies.CustomerService;

@SessionAttributes({"session_customer"})
@Controller
public class MappingController {
	
	@Autowired 
	private CustomerService customerService;

	@GetMapping("/stocks/chart")
	public String chart() {			
		return "stock_chart"; 
	}
	
	@ModelAttribute
	public Customer customer() {
		
		return new Customer();
	}
		
	
	@GetMapping("/stocks/chart/{stockId}/{stockName}/{stockQuantity}/{stockRegion}")
	public ModelAndView chart(@PathVariable("stockId") int stockId,@PathVariable("stockName") String stockName,@PathVariable("stockQuantity") int stockQuantity,@PathVariable("stockRegion") String stockRegion) {
      ModelAndView mv = new ModelAndView();
        
        Stock st = new Stock();
		
		st.setStockName(stockName);
		
		st.setStockRegion(stockRegion);
		
		st.setStockQuantity(stockQuantity);
		
		mv.addObject("stock",st); 
		
		mv.setViewName("stock_chart");
		
		return mv;
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
    public String registerProcess(@ModelAttribute Customer c, Model model) {
    	
    	Customer registeredCustomer = this.customerService.registerCustomer(c);
    	
    	model.addAttribute("session_customer", registeredCustomer);
    	
    	if(registeredCustomer != null) {
    		
    		return "register_success";
	   }
    	else {
    		return "reg_faiure";
    	}
    }
      
    @GetMapping("/logout")
    public String logout(SessionStatus session) {
    	
    	session.setComplete();
    	
    	return "stock_list";
    	
    }


}
