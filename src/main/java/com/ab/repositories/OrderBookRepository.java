package com.ab.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ab.models.OrderBook;

@EnableJpaRepositories
@Repository
public interface OrderBookRepository  extends JpaRepository<OrderBook, Integer> {

	
@Transactional
 @Query(value ="SELECT order_id,customer_id,order_price, SUM(order_price) as sum_order_price,order_quantity, sum(order_quantity) as sum_order_quantity,order_type,stock_region, stock_id, timestamp\n"
 		+ " FROM  Order_Book ob WHERE ob.customer_Id = :customerId GROUP BY ob.stock_Id", nativeQuery = true)
public List<OrderBook> showOrderBookCustomerId(@Param("customerId")int customerId);
	

//@Transactional
//@Query("FROM OrderBook ob where ob.customerId = :customerId")
//@Query(value = "select *,count(OrderBook.customerId) as numberOfOrders from OrderBook",nativeQuery = true)
//public List<OrderBook> groupStocks(@Param("stockId")int stockId,@Param("customerId") int customerId);
//}

//@Transactional
//@Query(value = "select *,count(OrderBook.customerId) as numberOfOrders from OrderBook",nativeQuery = true)
//public List<OrderBook> groupStocks(@Param("stockId")int stockId,@Param("customerId") int customerId);


}


//SELECT Shippers.ShipperName,COUNT(Orders.OrderID) AS NumberOfOrders FROM Orders
//LEFT JOIN Shippers ON Orders.ShipperID = Shippers.ShipperID
//GROUP BY ShipperName;
