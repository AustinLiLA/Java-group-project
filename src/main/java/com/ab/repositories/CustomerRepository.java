package com.ab.repositories;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ab.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	
	@Transactional
	@Query("From Customer c WHERE c.email = :email and c.password = :password")
    public Customer findByRecord(@Param("email") String email,@Param("password") String password);
	
}
