package com.ab.controllers;

import java.lang.annotation.Repeatable;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
	/*
	@PostMapping("/stocks/orderbook/{customerId}/{orderPrice}/{orderQuantity}/{orderType}/{stockId}")
	public OrderBook newOrder(@PathVariable("customerId") int customerId,@PathVariable("orderPrice") double orderPrice,@PathVariable("orderQuantity") int orderQuantity,@PathVariable("orderType") String orderType,@PathVariable("stockId") int stockId) {
		
		OrderBook or = new OrderBook(orderType, orderQuantity, orderPrice, customerId, stockId);
		System.out.println(or);
		return orderBookService.newOrder(or); 
		
	} */
	
	@PostMapping("/stocks/orderbook")
	public OrderBook newOrder(@RequestParam("orderId") int orderId, @RequestParam("orderType") String orderType, @RequestParam("Price") double price, @RequestParam("quantity") int quantity,@RequestParam("stockId") int stockId, @RequestParam("stockName") String stockName, @ModelAttribute("session_customer") Customer customer, @ModelAttribute("session_stock") List<Stock> stock) {
		
		OrderBook ob = null ;
		
		ob.setOrderId(orderId);
		ob.setOrderType(orderType);
		ob.setOrderPrice(price);
		ob.setOrderQuantity(quantity);
		ob.setStockId(stockId);
		ob.setStockName(stockName);
		
		
	    OrderBook ob1 = new OrderBook(customer.getCustomerId(), ob.getOrderId(), ob.getOrderType(), ob.getOrderQuantity(),ob.getOrderPrice(), stock.get(0).getStockId(),stock.get(0).getStockName());
		
		return orderBookService.newOrder(ob1);
		
	}

	@GetMapping("/stocks/orderbook/{customerId}/{orderId}/{orderType}/{Price}/{quantity}/{stockId}/{stockName}")
	public ModelAndView allOrderBooks(){
		
		ModelAndView mv = new ModelAndView();
		
		List<OrderBook> orderBookList = orderBookService.displayOrderBooks();		
		
		mv.addObject("orderBookList",orderBookList); 
		
		mv.setViewName("order_book");
		
		return mv; // represent "view name"/jsp file name
		
	}
	
	
	
	
}

