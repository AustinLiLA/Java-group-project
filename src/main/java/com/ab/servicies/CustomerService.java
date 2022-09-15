package com.ab.servicies;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ab.models.Customer;


@Service
public interface CustomerService {

	public Customer registerCustomer(Customer c);
	
	public Optional<Customer> loginCustomer(String email, String password);
	

	
	
}