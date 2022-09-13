package com.ab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ab.models.Customer;

public interface CustomerRepository extends JpaRepository <Customer,Integer> {

	Customer findByEmailAndPassword (String email, String password);
}
