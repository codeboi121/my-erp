package com.salesERP.erp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesERP.erp.entity.Sale;



public interface SaleRepository extends JpaRepository<Sale, Integer> {

	// that's it ... no need to write any code LOL!
	
	// search by name
//	public List<Sale> findByCustomerNameContainsAllIgnoreCase(String name);
	
	public Sale findTopByOrderByIdDesc();

}
 
