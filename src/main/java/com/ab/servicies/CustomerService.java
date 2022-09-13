package com.ab.servicies;

import com.ab.models.Customer;

public interface CustomerService {

	public Customer registerCustomer(Customer c);
	
	public Customer loginCustomer(String email, String password);
	
	
	
	
}
