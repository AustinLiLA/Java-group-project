package com.ab.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ab.models.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{

//	@Transactional
//	@Query("FROM Stock s WHERE s.stock_name= :stockName")
//	public Optional<Stock> displayStockByName(@Param("stockName") String stockName);

}
