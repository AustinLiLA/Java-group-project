package com.ab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ab.models.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{


}
