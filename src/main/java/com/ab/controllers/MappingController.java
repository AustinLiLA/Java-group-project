package com.ab.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ab.models.Customer;
import com.ab.models.Stock;
import com.ab.servicies.StockService;


@SessionAttributes({"session_customer"})
@Controller
public class MappingController {
	
	@Autowired
	private StockService stockService;
	HttpSession session;
	
	@GetMapping("/stocks/chart")
	public String chart() {			
		return "stock_chart"; 
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
	public String orderbook(@ModelAttribute Customer c, Model model) {
		
		@SuppressWarnings("unchecked")
		Optional <Customer> sessionCustomer = (Optional<Customer>) model.getAttribute("session_customer");
		if (sessionCustomer == null) {
			return "login";
		}
		else {
			return "order_book";
		}

		 
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

      
    @GetMapping("/logout")
    public ModelAndView logout(SessionStatus session) {

    	session.setComplete();
    	
    	

    	ModelAndView mv = new ModelAndView();
    		
    	List<Stock> stocks = stockService.displayStocks();		
    		
    	mv.addObject("stockList",stocks); 
    		
    	mv.setViewName("stock_list");

    	return mv; 
    		
    	

    }



}
