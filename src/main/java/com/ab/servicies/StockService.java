package com.ab.servicies;

import java.util.List;
import java.util.Optional;

import com.ab.models.Stock;


public interface StockService {
	
	public List<Stock> displayStocks();
	
	public Optional<Stock> displayStockById(int id);
	
//	public Optional<Stock> displayStockByName(String stockName);
	// public OrderBook buyStock (OrderBook orderBook)
	
	
	
}
