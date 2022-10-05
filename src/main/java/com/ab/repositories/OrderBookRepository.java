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

 @Query(value ="SELECT order_id,customer_id,SUM(order_price) as order_price,sum(order_quantity) as order_quantity,order_type, stock_id,stock_region,stock_name,timestamp FROM  Order_Book ob WHERE ob.customer_Id = :customerId GROUP BY ob.stock_Id", nativeQuery = true)

public List<OrderBook> showOrderBookCustomerId(@Param("customerId")int customerId);
}


