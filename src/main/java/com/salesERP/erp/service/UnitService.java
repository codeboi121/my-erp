package com.salesERP.erp.service;

import java.util.List;

import com.salesERP.erp.entity.Unit;


public interface UnitService {

	public List<Unit> findAll();
	
	public Unit findById(int theId);
	
	public void save(Unit theUnit);
	
	public void deleteById(int theId);

	public List<Unit> searchBy(String theName);
	
}
