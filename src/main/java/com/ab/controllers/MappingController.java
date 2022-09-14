package com.ab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/stocks/orderbook/{orderPrice}/{orderQuantity}/{orderType}")
	//@RequestMapping(path = "/stocks/orderbook/{orderPrice}/{orderQuantity}/{orderType}")
	public ModelAndView orderbook(@PathVariable("orderPrice") double orderPrice,@PathVariable("orderQuantity") int orderQuantity,@PathVariable("orderType") String orderType) {
		
		ModelAndView mv = new ModelAndView();

		OrderBook ob = new OrderBook();
		
		ob.setOrderPrice(orderPrice);
		ob.setOrderQuantity(orderQuantity);
		ob.setOrderType(orderType);
	
		mv.addObject("orderbook",ob); 
		
        mv.setViewName("order_book");
		
		return mv; 
	}
	
//	@GetMapping("/stocks/orderbook/{price}/{quantity}/{order}")
//	public String getOrderBook() {
//		
//		return "order_book";
//	}
	

	

}
