package com.salesERP.erp.service;

import java.util.List;

import com.salesERP.erp.entity.Sale;


public interface SaleService {

	public List<Sale> findAll();
	
	public Sale findById(int theId);
	
	public void save(Sale theSale);
	
	public void deleteById(int theId);

//	public List<Sale> searchBy(String theName);
	
	public Sale getLastRecord();
	
}
