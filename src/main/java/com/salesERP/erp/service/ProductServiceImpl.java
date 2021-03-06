package com.salesERP.erp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesERP.erp.dao.ProductRepository;
import com.salesERP.erp.entity.Product;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findById(int theId) {
		Optional<Product> result = productRepository.findById(theId);
		
		Product theProduct = null;
		
		if (result.isPresent()) {
			theProduct = result.get();
		}
		else {
			// we didn't find the product
			throw new RuntimeException("Did not find product id - " + theId);
		}
		
		return theProduct;
	}

	@Override
	public void save(Product theProduct) {
		productRepository.save(theProduct);
	}

	@Override
	public void deleteById(int theId) {
		productRepository.deleteById(theId);
	}

	@Override
	public List<Product> searchBy(String theName) {
		
		List<Product> results = null;
		
		if (theName != null && (theName.trim().length() > 0)) {
			results = productRepository.findByProductNameContainsAllIgnoreCase(theName );
		}
		else {
			results = findAll();
		}
		
		return results;
	}

}






