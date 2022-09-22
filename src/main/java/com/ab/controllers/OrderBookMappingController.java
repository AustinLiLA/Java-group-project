package com.ab.controllers;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ab.models.Customer;
import com.ab.models.OrderBook;
import com.ab.servicies.CustomerService;
import com.ab.servicies.OrderBookService;


@SessionAttributes({"session_customer","session_stock"})
@Controller
public class OrderBookMappingController {
	
	
	@Autowired
	private OrderBookService orderBookService;
	
	@Autowired
	private CustomerService customerService;
	
    @PostMapping("/stocks/orderInsert")
	public ModelAndView newOrder(@RequestParam("order") String orderType,@RequestParam("quantity") int quantity,@RequestParam("price") double price,@RequestParam("stockRegion") String stockRegion,@RequestParam("stockId") int stockId, Model model) {
  	Customer user = (Customer) model.getAttribute("session_customer");
	
    	double diff = user.getBalance();

  		if(diff > (price*quantity)) {
  			
    	orderBookService.newOrder(new OrderBook(orderType,quantity,price,stockRegion,LocalDateTime.now(),user.getCustomerId(),stockId));
    	
  		}
    	
    	if (orderType.equalsIgnoreCase("sell")) {
    	
    	 diff += (price*quantity);
    	 customerService.modifyCustomerBalance(diff, user.getCustomerId());
    	
    	}else if(orderType.equalsIgnoreCase("buy") && diff > (price*quantity)) {
    		
    	 diff -= (price*quantity);
    	 customerService.modifyCustomerBalance(diff, user.getCustomerId());
    	 
    	}
 
    	model.addAttribute("session_customer", new Customer(user.getCustomerId(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword(),diff));
    	
    	ModelAndView mv = new ModelAndView();
	 	 
        List<OrderBook> orderBookList =  orderBookService.displayOrderBooks();
		mv.addObject("orderBookList",orderBookList); 
		mv.setViewName("order_book");	
		return mv; 
	}
    
    @GetMapping("/stocks/orderInsert/orderByPrice")
	public ModelAndView newOrder2() {
	
    	ModelAndView mv = new ModelAndView();
	 	 
        List<OrderBook> orderBookList =  orderBookService.displayOrderBooksByPrice();
		mv.addObject("orderBookList",orderBookList); 
		
		mv.setViewName("order_book");
		
		
		return mv; 
	}
    

    @GetMapping("/stocks/orderInsert/orderByQuantity")
	public ModelAndView newOrder3() {
	
    	ModelAndView mv = new ModelAndView();
	 	 
        List<OrderBook> orderBookList =  orderBookService.displayOrderBooksByQuantity();
		mv.addObject("orderBookList",orderBookList); 
		
		mv.setViewName("order_book");
	
		
		return mv; 
	}
    
    
}
