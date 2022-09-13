package com.ab.servicies;

import java.util.List;

import com.ab.models.Stock;

public interface StockService {
	public List<Stock> displayStocks();
	public Stock displayStockByName(String name);
	//public OrderBook buyStock(OrderBook orderBook);
}
