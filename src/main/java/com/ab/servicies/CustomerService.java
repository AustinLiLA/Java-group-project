package com.ab.servicies;

import com.ab.models.Customer;

public interface CustomerService {

	public Customer loginCustomer(String email, String password);
	
	public Customer registerCustomer(Customer customer);
	
	
}
