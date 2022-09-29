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
 @Query("FROM OrderBook ob WHERE ob.customerId = :customerId")
public List<OrderBook> showOrderBookCustomerId(@Param("customerId")int customerId);
	

//Query example
//SELECT order_id,customer_id,SUM(order_price),sum(order_quantity),order_type,stock_region
//FROM order_book
//GROUP BY customer_id

}
