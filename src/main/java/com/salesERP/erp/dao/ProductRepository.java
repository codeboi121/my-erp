package com.salesERP.erp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesERP.erp.entity.Product;



public interface ProductRepository extends JpaRepository<Product, Integer> {

	
	
	// add a method to sort by last name
//	public List<Product> findAll();
	
	 //search by name
	public List<Product> findByProductNameContainsAllIgnoreCase(String name);

}
 
