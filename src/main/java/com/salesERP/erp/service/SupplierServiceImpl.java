package com.salesERP.erp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesERP.erp.dao.SupplierRepository;
import com.salesERP.erp.entity.Supplier;


@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Override
	public List<Supplier> findAll() {
		return supplierRepository.findAll();
	}

	@Override
	public Supplier findById(int theId) {
		Optional<Supplier> result = supplierRepository.findById(theId);
		
		Supplier theSuppliers = null;
		
		if (result.isPresent()) {
			theSuppliers = result.get();
		}
		else {
			// we didn't find the suppliers
			throw new RuntimeException("Did not find suppliers id - " + theId);
		}
		
		return theSuppliers;
	}

	@Override
	public void save(Supplier theSuppliers) {
		supplierRepository.save(theSuppliers);
	}

	@Override
	public void deleteById(int theId) {
		supplierRepository.deleteById(theId);
	}


//	@Override
//	public List<Sales> searchBy(String theName) {
//		
//		List<Sales> results = null;
//		
//		if (theName != null && (theName.trim().length() > 0)) {
//			results = supplierRepository.findBySalesNameContainsAllIgnoreCase(theName );
//		} 
//		else {
//			results = findAll();
//		}
//		
//		return results;
//	}
	
	
}






