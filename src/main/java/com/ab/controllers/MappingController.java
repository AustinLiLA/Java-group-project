package com.ab.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ab.models.Customer;
import com.ab.models.OrderBook;
import com.ab.models.Stock;
import com.ab.servicies.OrderBookService;
import com.ab.servicies.StockService;


@SessionAttributes({"session_customer","session_stock"})
@Controller
public class MappingController {
	
	@Autowired
	private StockService stockService;
	
	@Autowired
	private OrderBookService orderBookService;
	
	HttpSession session;
	
	@GetMapping("/stocks/chart")
	public String chart() {			
		return "stock_chart"; 
	}

	@GetMapping("/stocks/chart/{stockId}/{stockName}/{stockQuantity}/{stockRegion}")
	public ModelAndView chart(@PathVariable("stockId") int stockId,@PathVariable("stockName") String stockName,@PathVariable("stockQuantity") int stockQuantity,@PathVariable("stockRegion") String stockRegion) {
      
		ModelAndView mv = new ModelAndView();
        
        Stock st = new Stock();
		
		st.setStockName(stockName);
		
		st.setStockRegion(stockRegion);
		
		st.setStockQuantity(stockQuantity);
		
		mv.addObject("stock",st); 
		
		mv.setViewName("stock_chart");
		
		return mv;
	}
	
	
	
//	@GetMapping("/stocks/orderbook")
//	public String orderbook(@ModelAttribute Customer c, Model model) {
//		
//		@SuppressWarnings("unchecked")
//		Optional <Customer> sessionCustomer = (Optional<Customer>) model.getAttribute("session_customer");
//		if (sessionCustomer == null) {
//			return "login";
//		}
//		else {
//			return "order_book";
//		}
//
//		 
//	}
	
	@GetMapping("/login")
	public String login() {
		
		return "login"; 
	}
	
	//@GetMapping("/Register")
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String showRegistrationForm (){
    	
    	return "register";
    }

      
    @GetMapping("/logout")
    public ModelAndView logout(SessionStatus session) {

    	session.setComplete();	

    	ModelAndView mv = new ModelAndView();
    		
    	List<Stock> stocks = stockService.displayStocks();		
    		
    	mv.addObject("stockList",stocks); 
    		
    	mv.setViewName("stock_list");

    	return mv; 
    		
    	
    }
    
	@PostMapping("/stocks/orderbook")
	public String newOrder(@RequestParam("order") String orderType,@RequestParam("price") double price,@RequestParam("quantity") int quantity,@ModelAttribute("session_customer") Customer customer, @ModelAttribute("session_stock") List<Stock> stock) {
		
		 OrderBook ob;
			
	     ob = new OrderBook(stock.get(0).getStockId(), customer.getCustomerId(),orderType,price,quantity);
	    			
	    orderBookService.newOrder(ob);
		
	    
		return "order_book";
	}
    
//    @GetMapping("/stocks/orderbook")
//    public ModelAndView getOrderBook(@RequestParam("order") String orderType,@RequestParam("price") double price,@RequestParam("quantity") int quantity,@ModelAttribute("session_customer") Customer customer, @ModelAttribute("session_stock") List<Stock> stock) {
//
//    	ModelAndView mv = new ModelAndView();
//    	 	 
//        List<OrderBook> orderBookList =  orderBookService.displayOrderBooks();
//		
//		
//		mv.addObject("orderBookList",orderBookList); 
//		
//		mv.setViewName("orderBookList");
//	
//		return mv; 
//    		
//    	
//    }
    
//    @GetMapping("/stocks/orderbook")
//    public ModelAndView getOrderBook(@ModelAttribute OrderBook orderBook, Model model) {
//
//    	ModelAndView mv = new ModelAndView();
//    	 	 
//        List<OrderBook> orderBookList =  orderBookService.displayOrderBooks();
//		
//		System.out.println(orderBookList);
//		mv.addObject("orderBookList",orderBookList); 
//		
//		mv.setViewName("orderBookList");
//	
//		return mv; 
//    		
//    	
//    }
}
