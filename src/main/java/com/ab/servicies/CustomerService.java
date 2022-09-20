package com.ab.servicies;



import org.springframework.stereotype.Service;

import com.ab.models.Customer;




@Service
public interface CustomerService {

	public Customer registerCustomer(Customer c);
	
	public Customer loginCustomer(String email, String password);
	

	
	
}

