package com.ab.services;

import java.util.List;


import com.ab.models.MarketOrder;


public interface MarketOrderService {
	
	public MarketOrder newMarketOrder(MarketOrder marketOrder);
	
	public List<MarketOrder> displayMarketOrder();
	public List<MarketOrder> displayMarketOrderByPrice();
	public List<MarketOrder> displayMarketOrderByQuantity();
	public List<MarketOrder> displayMarketOrderByRegion();
	public List<MarketOrder> displayMarketOrderByStockId();
	
	public List<MarketOrder> findCustomerOrders(int id);
		

}
