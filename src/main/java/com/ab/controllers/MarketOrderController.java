package com.ab.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ab.models.Customer;
import com.ab.models.MarketOrder;
import com.ab.models.Stock;
import com.ab.services.MarketOrderService;



@SessionAttributes({"session_customer", "session_stock"})
@RestController
public class MarketOrderController {
	
	
	@Autowired
	private MarketOrderService marketOrderService;

	

	    
    @GetMapping("/portfolio")
    public ModelAndView getMarketOrderCustomerId(@ModelAttribute("session_customer") Customer customer,@ModelAttribute("session_stock") Stock stock,Model model) {
//    	Customer user = (Customer) model.getAttribute("session_customer");
    	ModelAndView mv = new ModelAndView();
    	    	 	 
        List<MarketOrder> marketOrderCustomerList =  marketOrderService.findCustomerOrders(customer.getCustomerId());
   
			mv.setViewName("portfolio");
			mv.addObject("marketOrderCustomerList",marketOrderCustomerList); 



			return mv;
	

    
}
}
	


