package com.ab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ab.servicies.StockService;

@RestController
public class StockController {

	@Autowired
	private StockService stockService;
	
}
