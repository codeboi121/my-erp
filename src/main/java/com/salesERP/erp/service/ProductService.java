package com.salesERP.erp.service;

import java.util.List;

import com.salesERP.erp.entity.Product;


public interface ProductService {

	public List<Product> findAll();
	
	public Product findById(int theId);
	
	public void save(Product theProduct);
	
	public void deleteById(int theId);

	public List<Product> searchBy(String theName);
	
}
