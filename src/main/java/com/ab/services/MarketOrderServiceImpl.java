package com.ab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ab.models.MarketOrder;
import com.ab.repositories.MarketOrderRepository;

@Service
public class MarketOrderServiceImpl implements MarketOrderService {

	@Autowired
	private MarketOrderRepository marketOrderRepository;
	

	
	@Override
	public MarketOrder newMarketOrder(MarketOrder marketOrder) {
		
		return marketOrderRepository.save(marketOrder);
	}
	//Format the date
	@Override
	public List<MarketOrder> displayMarketOrder(){
		return  marketOrderRepository.findAll();
	}

	@Override
	public List<MarketOrder> displayMarketOrderByPrice() {
		return marketOrderRepository.findAll(Sort.by(Sort.Direction.DESC, "mktOrderPrice"));
	}

	@Override
	public List<MarketOrder> displayMarketOrderByQuantity() {
		// TODO Auto-generated method stub
		return marketOrderRepository.findAll(Sort.by(Sort.Direction.DESC, "mktOrderQuantity"));
	}

	@Override
	public List<MarketOrder> displayMarketOrderByRegion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MarketOrder> displayMarketOrderByStockId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<MarketOrder> findCustomerOrders(int id) {
		// TODO Auto-generated method stub
		return marketOrderRepository.showOrderBookCustomerId(id);
	}
}
