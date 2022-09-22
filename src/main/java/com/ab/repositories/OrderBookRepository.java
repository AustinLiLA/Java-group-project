package com.ab.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ab.models.OrderBook;

@Repository
public interface OrderBookRepository  extends JpaRepository<OrderBook, Integer> {

	
//	@Transactional
// @Query("FROM Cars c WHERE c.carId = :carId")
//	public List<OrderBook> showCarById(@Param("carId")int carId);
	
}
