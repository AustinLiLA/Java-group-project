package com.ab.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ab.models.MarketOrder;


@EnableJpaRepositories
@Repository
public interface MarketOrderRepository  extends JpaRepository<MarketOrder, Integer> {

@Transactional
@Query(value ="SELECT mkt_Order_id,customer_id,SUM(mkt_Order_price) as mkt_Order_price,sum(mkt_Order_quantity) as mkt_Order_quantity,mkt_Order_type, stock_id,stock_region,stock_name,timestamp FROM  Market_Order mkt WHERE mkt.customer_Id = :customerId GROUP BY mkt.stock_Id", nativeQuery = true)
public List<MarketOrder> showOrderBookCustomerId(@Param("customerId")int customerId);
	

//@Transactional
//@Query("FROM OrderBook ob where ob.customerId = :customerId")
//@Query(value = "select *,count(OrderBook.customerId) as numberOfOrders from OrderBook",nativeQuery = true)
//public List<OrderBook> groupStocks(@Param("stockId")int stockId,@Param("customerId") int customerId);
//}


//SELECT Shippers.ShipperName,COUNT(Orders.OrderID) AS NumberOfOrders FROM Orders
//LEFT JOIN Shippers ON Orders.ShipperID = Shippers.ShipperID
//GROUP BY ShipperName;
}