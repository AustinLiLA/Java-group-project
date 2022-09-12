package com.ab.servicies;

import java.util.List;

import com.ab.models.Stock;

public interface StockService {
	public List<Stock> displayStocks();
	public Stock displayStockById(int id);
}
