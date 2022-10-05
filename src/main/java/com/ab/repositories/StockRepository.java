package com.ab.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.ab.models.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{

	
}
//@Query(value = "SELECT d.customerId,count(*) FROM senseer.DEVICE_REGISTRATION d  where d.customerId is not null group by d.customerId", nativeQuery=true)