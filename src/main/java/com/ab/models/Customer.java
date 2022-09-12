package com.ab.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	private int customerId ;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Double balance;
	public Customer() {
		super();
	}
	
	public Customer() {
		super();
		System.out.println("hello");
	}
	

	
}
