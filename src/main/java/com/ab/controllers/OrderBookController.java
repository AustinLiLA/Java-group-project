package com.ab.controllers;

import java.lang.annotation.Repeatable;
import java.util.List;

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
	/*
	@PostMapping("/stocks/orderbook/{customerId}/{orderPrice}/{orderQuantity}/{orderType}/{stockId}")
	public OrderBook newOrder(@PathVariable("customerId") int customerId,@PathVariable("orderPrice") double orderPrice,@PathVariable("orderQuantity") int orderQuantity,@PathVariable("orderType") String orderType,@PathVariable("stockId") int stockId) {
		
		OrderBook or = new OrderBook(orderType, orderQuantity, orderPrice, customerId, stockId);
		System.out.println(or);
		return orderBookService.newOrder(or); 
		
	} */
	

//	@PostMapping("/stocks/orderbook")
//	public OrderBook newOrder(@RequestParam("order") String orderType,@RequestParam("price") double price,@RequestParam("quantity") int quantity,@ModelAttribute("session_customer") Customer customer, @ModelAttribute("session_stock") List<Stock> stock) {
//		
//		 OrderBook ob = null;
//		 
//		 OrderBook st = null;
//		 
//		for (int i = 0; i < stock.size(); i++) {
//			
//	     ob = new OrderBook(stock.get(i).getStockId(), customer.getCustomerId(),orderType,price,quantity);
//	    			
//	    orderBookService.newOrder(ob);
//	    
//	    st = new OrderBook();
//			
//		st.setCustomerId(customer.getCustomerId());
//			
//		st.setStockId(stock.get(i).getStockId());
//			
//		st.setOrderType(orderType);
//			
//		st.setOrderQuantity(quantity);
//			
//		st.setOrderPrice(price);
//		
//		}
//		
//	    
//		return st;

//	}

//	@GetMapping("/stocks/orderbook/{customerId}/{orderPrice}/{orderQuantity}/{orderType}/{stockId}")
//	public ModelAndView allOrderBooks(){
//		
//		ModelAndView mv = new ModelAndView();
//		
//		List<OrderBook> orderBookList = orderBookService.displayOrderBooks();		
//		
//		mv.addObject("orderBookList",orderBookList); 
//		
//		mv.setViewName("order_book");
//		
//		return mv; // represent "view name"/jsp file name
//		
//	}
	
    @GetMapping("/stocks/orderbook")
    public ModelAndView getOrderBook(@ModelAttribute OrderBook orderBook, Model model) {

    	ModelAndView mv = new ModelAndView();
    	 	 
        List<OrderBook> orderBookList =  orderBookService.displayOrderBooks();
		
		System.out.println(orderBookList);
		mv.addObject("orderBookList",orderBookList); 
		
		mv.setViewName("order_book");
	
		return mv; 
    		
    	
    }

	
	
	
	
}

