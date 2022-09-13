package com.ab.servicies;

import java.util.List;
import java.util.Optional;

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
		return stockRepository.findAll();
	}
	
	@Override
	public Optional<Stock> displayStockById(int id){
	
		return stockRepository.findById(id) ;
	}
	
//	@Override
//	public Optional<Stock> displayStockByName(String stockName){
//	
//		return stockRepository.displayStockByName(stockName) ;
//	}


}
