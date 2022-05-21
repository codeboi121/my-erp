package com.salesERP.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesERP.erp.entity.Unit;
import com.salesERP.erp.service.UnitService;


@Controller
@RequestMapping("/units")
public class UnitController {

	@Autowired
	private UnitService unitService;
	
	// add mapping for "/list"
	@GetMapping("/list")
	public String listUnits(Model theModel) {
		
		// get units from db
		List<Unit> theUnits = unitService.findAll();
		
		// add to the spring model
		theModel.addAttribute("units", theUnits);
		
		return "/erpMenu/products/units/list-units";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Unit theUnit = new Unit();
		
		theModel.addAttribute("unit", theUnit);
		
		return "/erpMenu/products/units/unit-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("unitId") int theId,
									Model theModel) {
		
		// get the unit from the service
		Unit theUnit = unitService.findById(theId);
		
		// set unit as a model attribute to pre-populate the form
		theModel.addAttribute("unit", theUnit);
		
		// send over to our form
		return "/erpMenu/products/units/unit-form";			
	}
	
	
	@PostMapping("/save")
	public String saveUnit(@ModelAttribute("unit") Unit theUnit) {
		
		// save the unit
		unitService.save(theUnit);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/units/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("unitId") int theId) {
		
		// delete the unit
		unitService.deleteById(theId);
		
		// redirect to /units/list
		return "redirect:/units/list";
		
	}
	
	@GetMapping("/search")
	public String delete(@RequestParam("unitName") String theName,
						 Model theModel) {
		
		// delete the unit
		List<Unit> theUnit = unitService.searchBy(theName);
		
		// add to the spring model
		theModel.addAttribute("units", theUnit);
		
		// send to /units/list
		return "/erpMenu/units/list-units";
		
	}
	
}


















