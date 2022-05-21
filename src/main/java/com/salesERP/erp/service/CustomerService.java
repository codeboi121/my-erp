package com.salesERP.erp.service;

import java.util.List;

import com.salesERP.erp.entity.Customer;


public interface CustomerService {

	public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theCustomer);
	
	public void deleteById(int theId);

//	public List<Customer> searchBy(String theName);
	
}
