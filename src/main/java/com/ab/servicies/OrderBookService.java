package com.ab.servicies;

import java.util.List;

import com.ab.models.OrderBook;

public interface OrderBookService {
	
	public OrderBook newOrder(OrderBook orderBook);
	
	public List<OrderBook> displayOrderBooks();
	public List<OrderBook> displayOrderBooksByPrice();
	public List<OrderBook> displayOrderBooksByQuantity();
	public List<OrderBook> displayOrderBooksByRegion();
	public List<OrderBook> displayOrderBooksByStockId();
	
	public List<OrderBook> findCustomerOrders(int id);
	

}
