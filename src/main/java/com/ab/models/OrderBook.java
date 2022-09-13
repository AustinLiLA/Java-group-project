package com.ab.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class OrderBook {
	@Id
	private int orderId;
	
	private String orderType;
	private int orderQuantity;
	private Double orderPrice;
	
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name = "FK_customerId")
	private int customerId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name = "FK_stockId")
	private int stockId;
	
	public OrderBook() {
		super();
	}

	
	public OrderBook(int orderId, String orderType, int orderQuantity, Double orderPrice) {
		super();
		this.orderId = orderId;
		this.orderType = orderType;
		this.orderQuantity = orderQuantity;
		this.orderPrice = orderPrice;
	}
	
	


	public OrderBook( Double orderPrice,int orderQuantity,String orderType) {
		super();
		this.orderType = orderType;
		this.orderQuantity = orderQuantity;
		this.orderPrice = orderPrice;
	}
	
	
	public OrderBook(String orderType, int orderQuantity, Double orderPrice, int customerId, int stockId) {
		super();
		this.orderType = orderType;
		this.orderQuantity = orderQuantity;
		this.orderPrice = orderPrice;
		this.customerId = customerId;
		this.stockId = stockId;
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


	public Double getOrderPrice() {
		return orderPrice;
	}


	public void setOrderPrice(Double orderPrice) {
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
