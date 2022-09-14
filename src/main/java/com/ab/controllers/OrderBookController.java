package com.ab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.ab.servicies.OrderBookService;

@RestController
public class OrderBookController {
	
	
	@Autowired
	private OrderBookService orderBookService;
	
//	@PostMapping("/stocks/orderbook/{customerId}/{orderPrice}/{orderQuantity}/{orderType}/{stockId}")
//	public OrderBook newOrder(@PathVariable("customerId") int customerId,@PathVariable("orderPrice") double orderPrice,@PathVariable("orderQuantity") int orderQuantity,@PathVariable("orderType") String orderType,@PathVariable("stockId") int stockId) {
//		
//		OrderBook or = new OrderBook(orderType, orderQuantity, orderPrice, customerId, stockId);
//		System.out.println(or);
//		return orderBookService.newOrder(or);
//		
//	}
	
//	@PostMapping("/stocks/orderbook")
//	public OrderBook newOrder(@RequestBody OrderBook or) {
//	//	OrderBook or = new OrderBook(orderPrice,orderQuantity,orderType);
//		System.out.println(or);
//		return orderBookService.newOrder(or);
//		
//	}
	
	
	
	
}

