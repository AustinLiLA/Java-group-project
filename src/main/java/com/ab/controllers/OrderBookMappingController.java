package com.ab.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ab.models.Customer;
import com.ab.models.OrderBook;
import com.ab.servicies.OrderBookService;


@SessionAttributes({"session_customer","session_stock"})
@Controller
public class OrderBookMappingController {
	
	
	@Autowired
	private OrderBookService orderBookService;
	
    @PostMapping("/stocks/orderInsert")
	public ModelAndView newOrder(@RequestParam("order") String orderType,@RequestParam("quantity") int quantity,@RequestParam("price") double price,@RequestParam("stockRegion") String stockRegion,@RequestParam("stockId") int stockId,@ModelAttribute Customer customer, Model model) {
//    	Customer user = (Customer) model.getAttribute("session_customer");
		
//		if(user==null) {
//			return "noUser";
//		}
    	
    	
    	//change LocalDateTime format
    	orderBookService.newOrder(new OrderBook(orderType,quantity,price,stockRegion,LocalDateTime.now(),customer.getCustomerId(),stockId));
    	ModelAndView mv = new ModelAndView();
	 	 
        List<OrderBook> orderBookList =  orderBookService.displayOrderBooks();
		
		System.out.println(orderBookList);
		mv.addObject("orderBookList",orderBookList); 
		
		mv.setViewName("order_book");
	
		
		return mv; 
	}
    

    
}
