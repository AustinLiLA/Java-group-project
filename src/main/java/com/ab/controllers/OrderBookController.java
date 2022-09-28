package com.ab.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ab.models.Customer;
import com.ab.models.OrderBook;
import com.ab.models.Stock;
import com.ab.servicies.OrderBookService;



@SessionAttributes({"session_customer", "session_stock"})
@RestController
public class OrderBookController {
	
	
	@Autowired
	private OrderBookService orderBookService;
	
	
	
    
    @GetMapping("/portfolio")
    public ModelAndView getOrderBookCustomerId(@ModelAttribute("session_customer") Customer customer,Stock stock,Model model) {
    	Customer user = (Customer) model.getAttribute("session_customer");
    	ModelAndView mv = new ModelAndView();
    	    	 	 
        List<OrderBook> orderBookCustomerList =  orderBookService.findCustomerOrders(customer.getCustomerId());
  
//        List<OrderBook> groupStocks = orderBookService.groupStocks(stock.getStockId(), customer.getCustomerId());
        
       
		
		
		
			mv.setViewName("portfolio");
			mv.addObject("orderBookCustomerList",orderBookCustomerList); 
//			mv.addObject("groupStocks",groupStocks); 

			return mv;
	

    
}
}
	


