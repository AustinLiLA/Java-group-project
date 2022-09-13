package com.ab.servicies;

import org.springframework.beans.factory.annotation.Autowired;

import com.ab.models.Customer;
import com.ab.repositories.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer registerCustomer(Customer c) {
		
		return customerRepository.save(c);
		
	}

	@Override
	public Customer loginCustomer(String email, String password) {
		return customerRepository.findByEmailAndPassword(email, password);
	}

	

}
