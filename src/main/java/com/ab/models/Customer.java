package com.ab.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	
	

	
}
