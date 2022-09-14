package com.ab.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.models.OrderBook;
import com.ab.repositories.OrderBookRepository;

@Service
public class OrderBookServiceImpl implements OrderBookService {

	@Autowired
	private OrderBookRepository orderBookRepository;
	
	
	@Override
	public OrderBook newOrder(OrderBook orderBook) {
		
		return orderBookRepository.save(orderBook);
	}
	
	@Override
	public List<OrderBook> displayOrderBooks(){
		
		return  orderBookRepository.findAll();
	}

}
