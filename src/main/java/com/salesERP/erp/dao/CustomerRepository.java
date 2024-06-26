package com.salesERP.erp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesERP.erp.entity.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	
	
	// add a method to sort by last name
//	public List<Customer> findAll();
	
	// search by name
	public List<Customer> findByCustomerNameContainsAllIgnoreCase(String name);

}
 
