package com.salesERP.erp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesERP.erp.entity.Unit;



public interface UnitRepository extends JpaRepository<Unit, Integer> {
	// search by name
	List<Unit> findByUnitNameContainsAllIgnoreCase(String theName);

	
	
}
 
