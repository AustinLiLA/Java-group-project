package com.ab.models;




import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class OrderBook {
	@Id
	private int orderId;
	
	private String orderType;
	private int orderQuantity;
	private double orderPrice;
	private String stockRegion;
	private LocalDateTime timestamp;
	
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name = "FK_customerId")
	private int customerId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name = "FK_stockId")
	private int stockId;
	
<<<<<<< HEAD
	private String stockName;
=======
	
>>>>>>> 079a28e5a0a826d55e8f3e5ca8fdd92d901c6aa1
	public OrderBook() {
		super();
	}

	
<<<<<<< HEAD
	public OrderBook(int customerId,int orderId, String orderType, int orderQuantity, double orderPrice,  int stockId,
			String stockName) {
=======
	public OrderBook(int orderId, String orderType, int orderQuantity, double orderPrice, String stockRegion,
			LocalDateTime timestamp, int customerId, int stockId) {
>>>>>>> 079a28e5a0a826d55e8f3e5ca8fdd92d901c6aa1
		super();
		this.orderId = orderId;
		this.orderType = orderType;
		this.orderQuantity = orderQuantity;
		this.orderPrice = orderPrice;
<<<<<<< HEAD
		this.customerId = customerId;
		this.stockId = stockId;
		this.stockName = stockName;
=======
		this.stockRegion = stockRegion;
		this.timestamp = timestamp;
		this.customerId = customerId;
		this.stockId = stockId;
	}


	public OrderBook(String orderType, int orderQuantity, double orderPrice, String stockRegion,
			LocalDateTime timestamp, int customerId, int stockId) {
		super();
		this.orderType = orderType;
		this.orderQuantity = orderQuantity;
		this.orderPrice = orderPrice;
		this.stockRegion = stockRegion;
		this.timestamp = timestamp;
		this.customerId = customerId;
		this.stockId = stockId;
>>>>>>> 079a28e5a0a826d55e8f3e5ca8fdd92d901c6aa1
	}


	public OrderBook(int orderId, String orderType, int orderQuantity, double orderPrice) {
		super();
		this.orderId = orderId;
		this.orderType = orderType;
		this.orderQuantity = orderQuantity;
		this.orderPrice = orderPrice;
	}
	
	


	public OrderBook( double orderPrice,int orderQuantity,String orderType) {
		super();
		this.orderType = orderType;
		this.orderQuantity = orderQuantity;
		this.orderPrice = orderPrice;
	}
	
	
	public OrderBook(String orderType, int orderQuantity, double orderPrice, int customerId, int stockId) {
		super();
		this.orderType = orderType;
		this.orderQuantity = orderQuantity;
		this.orderPrice = orderPrice;
		this.customerId = customerId;
		this.stockId = stockId;
	}
	
	public OrderBook(int stockId, int customerId, String orderType, double orderPrice, int orderQuantity) {
		super();
		this.orderType = orderType;
		this.orderQuantity = orderQuantity;
		this.orderPrice = orderPrice;
		this.customerId = customerId;
		this.stockId = stockId;
	}


	


	public OrderBook(String orderType, int orderQuantity, double orderPrice) {
		super();
		this.orderType = orderType;
		this.orderQuantity = orderQuantity;
		this.orderPrice = orderPrice;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public String getOrderType() {
		return orderType;
	}


	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}


	public int getOrderQuantity() {
		return orderQuantity;
	}


	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}


	public double getOrderPrice() {
		return orderPrice;
	}


	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public int getStockId() {
		return stockId;
	}


	public void setStockId(int stockId) {
		this.stockId = stockId;
	}


	public String getStockRegion() {
		return stockRegion;
	}


	public void setStockRegion(String stockRegion) {
		this.stockRegion = stockRegion;
	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


	@Override
	public String toString() {
		return "OrderBook [orderId=" + orderId + ", orderType=" + orderType + ", orderQuantity=" + orderQuantity
				+ ", orderPrice=" + orderPrice + ", stockRegion=" + stockRegion + ", timestamp=" + timestamp
				+ ", customerId=" + customerId + ", stockId=" + stockId + "]";
	}


<<<<<<< HEAD
	public void setStockName(String stockName) {
		this.stockName = stockName;
		
	}
=======
	
>>>>>>> 079a28e5a0a826d55e8f3e5ca8fdd92d901c6aa1
	
	
	
	
	
}
