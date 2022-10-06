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
		return mv;		

	}
    @GetMapping("/stocks/orderbookShow")
    public ModelAndView getOrderBook() {

    	ModelAndView mv = new ModelAndView();
    	 	 
        List<OrderBook> orderBookList =  orderBookService.displayOrderBooks();

		
		System.out.println(orderBookList);
		mv.addObject("orderBookList",orderBookList); 
		
		mv.setViewName("order_book");
	
		return mv;
    }
	    
    @GetMapping("/portfolio")
    public ModelAndView getOrderBookCustomerId(@ModelAttribute("session_customer") Customer customer,@ModelAttribute("session_stock") Stock stock,Model model) {
    	Customer user = (Customer) model.getAttribute("session_customer");
    	ModelAndView mv = new ModelAndView();
    	    	 	 
        List<OrderBook> orderBookCustomerList =  orderBookService.findCustomerOrders(customer.getCustomerId());
        System.out.println(orderBookCustomerList);
   
			mv.setViewName("portfolio");
			mv.addObject("orderBookCustomerList",orderBookCustomerList); 



			return mv;
	

    
}
}
	


