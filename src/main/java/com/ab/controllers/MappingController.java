package com.ab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.ab.models.OrderBook;
import com.ab.models.Stock;


@Controller
public class MappingController {
	
	
	
	@GetMapping("/stocks/chart/{stockName}/{stockRegion}/{stockQuantity}")
	public ModelAndView chart(@PathVariable("stockName") String stockName,@PathVariable("stockRegion") String stockRegion,@PathVariable("stockQuantity") int stockQuantity) {
		
        ModelAndView mv = new ModelAndView();
        
        Stock st = new Stock();
		
		st.setStockName(stockName);
		
		st.setStockRegion(stockRegion);
		
		st.setStockQuantity(stockQuantity);
		
		mv.addObject("stock",st); 
		
		mv.setViewName("stock_chart");
		
		return mv; 
		
	}
	
	@GetMapping("/stocks/orderbook/{price}/{quantity}/{order}")
	public ModelAndView orderbook(@PathVariable("price") double price,@PathVariable("quantity") int quantity,@PathVariable("order") String order) {
		
		ModelAndView mv = new ModelAndView();

		OrderBook ob = new OrderBook();
		
		ob.setOrderPrice(price);
		ob.setOrderQuantity(quantity);
		ob.setOrderType(order);
		
		mv.addObject("orderbook",ob); 
		
        mv.setViewName("order_book");
		
		return mv; 
	}

}
