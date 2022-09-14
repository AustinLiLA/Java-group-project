package com.ab.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.models.Customer;
import com.ab.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer loginCustomer(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer registerCustomer(Customer c) {
		
		return customerRepository.save(c);
	}

}
