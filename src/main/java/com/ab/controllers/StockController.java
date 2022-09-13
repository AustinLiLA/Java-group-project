package com.ab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ab.models.Stock;
import com.ab.servicies.StockService;

@RestController
public class StockController {

	@Autowired
	private StockService stockService;
	
	@GetMapping("/stocks")
	public ModelAndView allStocks(){
		
		ModelAndView mv = new ModelAndView();
		
		List<Stock> stocks = stockService.displayStocks();
		
		
		mv.addObject("stockList",stocks); 
		
		mv.setViewName("stock_list");
		
		return mv; // represent "view name"/jsp file name
		
	}
	
	
	
	
}

