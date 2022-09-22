package com.ab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ab.models.Customer;
import com.ab.models.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{

	//@Transactional
	//@Query("From Stock s WHERE s.stockId = :stockId")
    //public Stock findStocks(@Param("stockId") int stockId);
}
