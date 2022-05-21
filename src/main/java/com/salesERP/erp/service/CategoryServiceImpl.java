package com.salesERP.erp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesERP.erp.dao.CategoryRepository;
import com.salesERP.erp.entity.Category;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(int theId) {
		Optional<Category> result = categoryRepository.findById(theId);
		
		Category theCategory = null;
		
		if (result.isPresent()) {
			theCategory = result.get();
		}
		else {
			// we didn't find the category
			throw new RuntimeException("Did not find category id - " + theId);
		}
		
		return theCategory;
	}

	@Override
	public void save(Category theCategory) {
		categoryRepository.save(theCategory);
	}

	@Override
	public void deleteById(int theId) {
		categoryRepository.deleteById(theId);
	}

	@Override
	public List<Category> searchBy(String theName) {
		
		List<Category> results = null;
		
		if (theName != null && (theName.trim().length() > 0)) {
			results = categoryRepository.findByCategoryNameContainsAllIgnoreCase(theName );
		}
		else {
			results = findAll();
		}
		
		return results;
	}

}






