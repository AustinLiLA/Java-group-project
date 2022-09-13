package com.ab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MappingController {
	
	
	
	@GetMapping("/stocks/chart")
	public String chart() {
		
		return "stock_chart"; 
	}
	
	@GetMapping("/stocks/orderbook")
	public String orderbook() {
		
		return "order_book"; 
	}

}
