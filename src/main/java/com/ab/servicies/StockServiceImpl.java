package com.ab.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.models.Stock;
import com.ab.repositories.StockRepository;


@Service
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository stockRepository;
	

	@Override
	public List<Stock> displayStocks() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Stock displayStockByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
