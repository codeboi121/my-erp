package com.salesERP.erp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesERP.erp.dao.SaleRepository;
import com.salesERP.erp.entity.Sale;


@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	private SaleRepository saleRepository;
	
	@Override
	public List<Sale> findAll() {
		return saleRepository.findAll();
	}

	@Override
	public Sale findById(int theId) {
		Optional<Sale> result = saleRepository.findById(theId);
		
		Sale theSales = null;
		
		if (result.isPresent()) {
			theSales = result.get();
		}
		else {
			// we didn't find the sales
			throw new RuntimeException("Did not find sales id - " + theId);
		}
		
		return theSales;
	}

	@Override
	public void save(Sale theSales) {
		saleRepository.save(theSales);
	}

	@Override
	public void deleteById(int theId) {
		saleRepository.deleteById(theId);
	}


//	@Override
//	public List<Sales> searchBy(String theName) {
//		
//		List<Sales> results = null;
//		
//		if (theName != null && (theName.trim().length() > 0)) {
//			results = saleRepository.findBySalesNameContainsAllIgnoreCase(theName );
//		} 
//		else {
//			results = findAll();
//		}
//		
//		return results;
//	}
	
	@Override
	public Sale getLastRecord() {
		Sale theSale=saleRepository.findTopByOrderByIdDesc();
		return theSale;
	}
	
}






