package com.salesERP.erp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesERP.erp.entity.Category;



public interface CategoryRepository extends JpaRepository<Category, Integer> {
	// search by name
	List<Category> findByCategoryNameContainsAllIgnoreCase(String theName);

	
	
}
 
