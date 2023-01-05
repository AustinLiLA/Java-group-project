package com.ab.controllers;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ab.models.Customer;
import com.ab.models.MarketOrder;
import com.ab.models.TradingHistory;
import com.ab.services.CustomerService;
import com.ab.services.MarketOrderService;
import com.ab.services.TradingHistoryService;


@SessionAttributes({"session_customer","session_stock"})
@Controller
public class MarketOrderMappingController {
	
	
	@Autowired
	private MarketOrderService marketOrderService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private TradingHistoryService thService;
	
	
	//global ModelAndView variable
	ModelAndView mv = new ModelAndView();
	
    @PostMapping("/stocks/trading_data")
	public ModelAndView newMarketOrder(@RequestParam("order") String mktOrderType,@RequestParam("quantity") int quantity,@RequestParam("price") double price,@RequestParam("stockRegion") String stockRegion,@RequestParam("stockName") String stockName,@RequestParam("stockId") int stockId, Model model) {

  	Customer user = (Customer) model.getAttribute("session_customer");
  	String myString= LocalDateTime.now().toString().replace('T',' ');

  	
  		if(user != null) {
  		
    	double currentBalance = user.getBalance();

  		if(currentBalance > (price*quantity)) {
  		
    	marketOrderService.newMarketOrder(new MarketOrder(mktOrderType,quantity,price,stockRegion,stockName,myString,user.getCustomerId(),stockId));
    	
    	// TradingHistory
    	thService.newTradingHistory(new TradingHistory(mktOrderType,quantity,price,myString,user.getCustomerId(),stockId));
    	
  		}
    	
    	if (mktOrderType.equalsIgnoreCase("sell")) {
    	
    	 currentBalance += (price*quantity);
    	 customerService.modifyCustomerBalance(currentBalance, user.getCustomerId());
    	
    	}else if(mktOrderType.equalsIgnoreCase("buy") && currentBalance > (price*quantity)) {
    		
    	 currentBalance -= (price*quantity);
    	 customerService.modifyCustomerBalance(currentBalance, user.getCustomerId());
    	 
    	}
 
    	model.addAttribute("session_customer", new Customer(user.getCustomerId(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword(),currentBalance));
    	model.addAttribute("session_stock");
	 	 
        List<MarketOrder> marketOrderList =  marketOrderService.displayMarketOrder();
		mv.addObject("marketOrderList",marketOrderList); 
		mv.setViewName("stock_chart");	
		return mv; 
	}else {
		mv.setViewName("noUser");
		return mv;
	}
	}
  		
    
    @GetMapping("/stocks/trading_data")
	public ModelAndView newMarketOrder(Model model) {	 
	 	 
        List<MarketOrder> marketOrderList =  marketOrderService.displayMarketOrder();
		mv.addObject("marketOrderList",marketOrderList); 
		mv.setViewName("trading_data");	
		return mv; 
	}
    
    @GetMapping("/stocks/trading_data/marketOrderByPrice")
	public ModelAndView newMarketOrder2() {
	 	 
        List<MarketOrder> marketOrderList =  marketOrderService.displayMarketOrderByPrice();
		mv.addObject("marketOrderList",marketOrderList); 
		
		mv.setViewName("trading_data");
		
		
		return mv; 
	}
    

    @GetMapping("/stocks/trading_data/marketOrderByQuantity")
	public ModelAndView newMarketOrder3() {
	 	 
        List<MarketOrder> marketOrderList =  marketOrderService.displayMarketOrderByQuantity();
		mv.addObject("marketOrderList",marketOrderList); 
		
		mv.setViewName("trading_data");
	
		
		return mv; 
	}
    
    
    
    
}
