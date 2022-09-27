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
	

//@Transactional
//@Query("FROM OrderBook ob where ob.customerId = :customerId")
@Query(value = "select *,count(OrderBook.customerId) as numberOfOrders from OrderBook",nativeQuery = true)
public List<OrderBook> groupStocks(@Param("stockId")int stockId,@Param("customerId") int customerId);
}


//@Query("select new com.demo.entities.CategoryGroup(p.category.id as categoryId, "
//		+ "min(p.price) as minPrice, "
//		+ "max(p.price) as maxPrice, "
//		+ "sum(p.quantity) as sumQuantity, "
//		+ "count(p.id) as countProduct, "
//		+ "avg(p.price) as avgPrice) "
//		+ "from Product p "
//		+ "group by p.category.id")


//SELECT Shippers.ShipperName,COUNT(Orders.OrderID) AS NumberOfOrders FROM Orders
//LEFT JOIN Shippers ON Orders.ShipperID = Shippers.ShipperID
//GROUP BY ShipperName;