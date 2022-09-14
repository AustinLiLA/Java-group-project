package com.ab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.ab.models.Customer;
import com.ab.models.OrderBook;
import com.ab.models.Stock;
import com.ab.servicies.OrderBookService;

@SessionAttributes({"session_customer"})
@RestController
public class OrderBookController {
	
	
	@Autowired
	private OrderBookService orderBookService;
	/*
	@PostMapping("/stocks/orderbook/{customerId}/{orderPrice}/{orderQuantity}/{orderType}/{stockId}")
	public OrderBook newOrder(@PathVariable("customerId") int customerId,@PathVariable("orderPrice") double orderPrice,@PathVariable("orderQuantity") int orderQuantity,@PathVariable("orderType") String orderType,@PathVariable("stockId") int stockId) {
		
		OrderBook or = new OrderBook(orderType, orderQuantity, orderPrice, customerId, stockId);
		System.out.println(or);
		return orderBookService.newOrder(or); 
		
	} */
	
//	@PostMapping("/stocks/orderbook")
//	public OrderBook newOrder(@ModelAttribute OrderBook or, @ModelAttribute("session_customer") Customer customer) {
//		
//		
//	    OrderBook or = new OrderBook(or.ge,orderQuantity,orderType,customer.getCustomerId());
//		System.out.println(or);
//		return orderBookService.newOrder(or);
//		
//	}

	@GetMapping("/stocks/orderbook/{customerId}/{orderPrice}/{orderQuantity}/{orderType}/{stockId}")
	public ModelAndView allOrderBooks(){
		
		ModelAndView mv = new ModelAndView();
		
		List<OrderBook> orderBookList = orderBookService.displayOrderBooks();		
		
		mv.addObject("orderBookList",orderBookList); 
		
		mv.setViewName("order_book");
		
		return mv; // represent "view name"/jsp file name
		
	}
	
	
	
	
}

