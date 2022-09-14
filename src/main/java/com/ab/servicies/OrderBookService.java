package com.ab.servicies;

import java.util.List;

import com.ab.models.OrderBook;

public interface OrderBookService {
	
	public OrderBook newOrder(OrderBook orderBook);
	
	public List<OrderBook> displayOrderBooks();

}
