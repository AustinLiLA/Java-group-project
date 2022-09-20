package com.ab.models;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class OrderBook {
	@Id
	private int orderId;
	
	private String orderType;
	private int orderQuantity;
	private double orderPrice;
	
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name = "FK_customerId")
	private int customerId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name = "FK_stockId")
	private int stockId;
	
	public OrderBook() {
		super();
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


	@Override
	public String toString() {
		return "OrderBook [orderId=" + orderId + ", orderType=" + orderType + ", orderQuantity=" + orderQuantity
				+ ", orderPrice=" + orderPrice + "]";
	}
	
	
	
	
	
}
