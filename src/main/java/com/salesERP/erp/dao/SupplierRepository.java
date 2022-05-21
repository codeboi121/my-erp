package com.salesERP.erp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesERP.erp.entity.Supplier;



public interface SupplierRepository extends JpaRepository<Supplier, Integer> {


	// that's it ... no need to write any code LOL!
	
	// search by name
//	public List<Supplier> findByCustomerNameContainsAllIgnoreCase(String name);
	
}
 
