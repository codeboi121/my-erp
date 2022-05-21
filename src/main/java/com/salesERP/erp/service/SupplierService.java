package com.salesERP.erp.service;

import java.util.List;

import com.salesERP.erp.entity.Supplier;


public interface SupplierService {

	public List<Supplier> findAll();
	
	public Supplier findById(int theId);
	
	public void save(Supplier theSupplier);
	
	public void deleteById(int theId);

//	public List<Supplier> searchBy(String theName);
	
	
}
