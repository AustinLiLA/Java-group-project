package com.ab.models;



import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class MarketOrder {
	@Id
	private int mktOrderId;
	
	private String mktOrderType;
	private int mktOrderQuantity;
	private double mktOrderPrice;
	private String stockRegion;
	private String stockName;
	private String timestamp;
	
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name = "FK_customerId")
	private int customerId;
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name = "FK_stockId")
	private int stockId;
	



	

	public MarketOrder() {
		super();
	}

	

	public MarketOrder(int customerId,int mktOrderId, String mktOrderType, int mktOrderQuantity, double mktOrderPrice,  int stockId,
			String stockName) {

	}
	public MarketOrder(String mktOrderType, int mktOrderQuantity, double mktOrderPrice, String stockRegion,
			String stockName, String timestamp, int customerId, int stockId) {
		super();
		this.mktOrderType = mktOrderType;
		this.mktOrderQuantity = mktOrderQuantity;
		this.mktOrderPrice = mktOrderPrice;
		this.stockRegion = stockRegion;
		this.stockName = stockName;
		this.timestamp = timestamp;
		this.customerId = customerId;
		this.stockId = stockId;
	}

	public MarketOrder(int mktOrderId, String mktOrderType, int mktOrderQuantity, double mktOrderPrice, String stockRegion,



			String timestamp, int customerId, int stockId) {

		super();
		this.mktOrderId = mktOrderId;
		this.mktOrderType = mktOrderType;
		this.mktOrderQuantity = mktOrderQuantity;
		this.mktOrderPrice = mktOrderPrice;

		this.customerId = customerId;
		this.stockId = stockId;

		this.stockRegion = stockRegion;
		this.timestamp = timestamp;
		this.customerId = customerId;
		this.stockId = stockId;
	}


	public MarketOrder(String mktOrderType, int mktOrderQuantity, double mktOrderPrice, String stockRegion,
			String timestamp, int customerId, int stockId) {
		super();
		this.mktOrderType = mktOrderType;
		this.mktOrderQuantity = mktOrderQuantity;
		this.mktOrderPrice = mktOrderPrice;
		this.stockRegion = stockRegion;
		this.timestamp = timestamp;
		this.customerId = customerId;
		this.stockId = stockId;

	}


	public MarketOrder(int mktOrderId, String mktOrderType, int mktOrderQuantity, double mktOrderPrice) {
		super();
		this.mktOrderId = mktOrderId;
		this.mktOrderType = mktOrderType;
		this.mktOrderQuantity = mktOrderQuantity;
		this.mktOrderPrice = mktOrderPrice;
	}
	
	


	public MarketOrder( double mktOrderPrice,int mktOrderQuantity,String mktOrderType) {
		super();
		this.mktOrderType = mktOrderType;
		this.mktOrderQuantity = mktOrderQuantity;
		this.mktOrderPrice = mktOrderPrice;
	}
	
	
	public MarketOrder(String mktOrderType, int mktOrderQuantity, double mktOrderPrice, int customerId, int stockId) {
		super();
		this.mktOrderType = mktOrderType;
		this.mktOrderQuantity = mktOrderQuantity;
		this.mktOrderPrice = mktOrderPrice;
		this.customerId = customerId;
		this.stockId = stockId;
	}
	
	public MarketOrder(int stockId, int customerId, String mktOrderType, double mktOrderPrice, int mktOrderQuantity) {
		super();
		this.mktOrderType = mktOrderType;
		this.mktOrderQuantity = mktOrderQuantity;
		this.mktOrderPrice = mktOrderPrice;
		this.customerId = customerId;
		this.stockId = stockId;
	}

	


	public MarketOrder(String mktOrderType, int mktOrderQuantity, double mktOrderPrice) {
		super();
		this.mktOrderType = mktOrderType;
		this.mktOrderQuantity = mktOrderQuantity;
		this.mktOrderPrice = mktOrderPrice;
	}


	public int getmktOrderId() {
		return mktOrderId;
	}


	public void setmktOrderId(int mktOrderId) {
		this.mktOrderId = mktOrderId;
	}


	public String getmktOrderType() {
		return mktOrderType;
	}


	public void setmktOrderType(String mktOrderType) {
		this.mktOrderType = mktOrderType;
	}


	public int getmktOrderQuantity() {
		return mktOrderQuantity;
	}


	public void setmktOrderQuantity(int mktOrderQuantity) {
		this.mktOrderQuantity = mktOrderQuantity;
	}


	public double getmktOrderPrice() {
		return mktOrderPrice;
	}


	public void setmktOrderPrice(double mktOrderPrice) {
		this.mktOrderPrice = mktOrderPrice;
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


	public String getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	
	
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}


	public String getStockName() {
		return stockName;
	}


	@Override
	public String toString() {
		return "OrderBook [mktOrderId=" + mktOrderId + ", mktOrderType=" + mktOrderType + ", mktOrderQuantity=" + mktOrderQuantity
				+ ", mktOrderPrice=" + mktOrderPrice + ", stockRegion=" + stockRegion + ", timestamp=" + timestamp
				+ ", customerId=" + customerId + ", stockId=" + stockId + "]";
	}



	}


	
	
	
	
	

