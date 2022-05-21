package com.salesERP.erp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesERP.erp.dao.UnitRepository;
import com.salesERP.erp.entity.Unit;


@Service
public class UnitServiceImpl implements UnitService {

	@Autowired
	private UnitRepository unitRepository;
	
	@Override
	public List<Unit> findAll() {
		return unitRepository.findAll();
	}

	@Override
	public Unit findById(int theId) {
		Optional<Unit> result = unitRepository.findById(theId);
		
		Unit theUnit = null;
		
		if (result.isPresent()) {
			theUnit = result.get();
		}
		else {
			// we didn't find the unit
			throw new RuntimeException("Did not find unit id - " + theId);
		}
		
		return theUnit;
	}

	@Override
	public void save(Unit theUnit) {
		unitRepository.save(theUnit);
	}

	@Override
	public void deleteById(int theId) {
		unitRepository.deleteById(theId);
	}

	@Override
	public List<Unit> searchBy(String theName) {
		
		List<Unit> results = null;
		
		if (theName != null && (theName.trim().length() > 0)) {
			results = unitRepository.findByUnitNameContainsAllIgnoreCase(theName );
		}
		else {
			results = findAll();
		}
		
		return results;
	}

}






