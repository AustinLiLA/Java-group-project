package com.ab.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
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
}


