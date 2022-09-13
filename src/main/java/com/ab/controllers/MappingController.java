package com.ab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class MappingController {
	
	
	
	@GetMapping("/stocks/chart/{stockName}/{stockRegion}")
	public String chart(@PathVariable("stockName") String stockName,@PathVariable("stockRegion") String stockRegion) {
		
		System.out.println(stockName + ","+stockRegion);			
		return "stock_chart"; 
	}
	
	@GetMapping("/stocks/orderbook")
	public String orderbook() {
		
		return "order_book"; 
	}

}
