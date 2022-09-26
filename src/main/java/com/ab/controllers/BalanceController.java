package com.ab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BalanceController{
	
	@GetMapping("balance")
	public String balance() {
		return "balance";	}
}