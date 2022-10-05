package com.ab.controllers;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
	
<<<<<<< HEAD
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
=======
	
    @GetMapping("/stocks/orderbookShow")
    public ModelAndView getOrderBook() {

    	ModelAndView mv = new ModelAndView();
    	 	 
        List<OrderBook> orderBookList =  orderBookService.displayOrderBooks();
>>>>>>> 079a28e5a0a826d55e8f3e5ca8fdd92d901c6aa1
		
		System.out.println(orderBookList);
		mv.addObject("orderBookList",orderBookList); 
		
		mv.setViewName("order_book");
	
		return mv; 

    }

    
	
	
	
}

