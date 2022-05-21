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

import com.salesERP.erp.entity.Supplier;
import com.salesERP.erp.service.SupplierService;


@Controller
@RequestMapping("/suppliers")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;
	
	// add mapping for supplier link
	@GetMapping("/contents")
	public String dashBoardContents() {
		return "/erpMenu/suppliers/supplierContents";
	}
		
	// add mapping for "/list"
	@GetMapping("/list")
	public String listSuppliers(Model theModel) {
		
		// get supplier from db
		List<Supplier> theSuppliers = supplierService.findAll();
		
		// add to the spring model
		theModel.addAttribute("suppliers", theSuppliers);
		
		return "/erpMenu/suppliers/list-suppliers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Supplier theSupplier = new Supplier();
		
		theModel.addAttribute("supplier", theSupplier);
		
		return "/erpMenu/suppliers/supplier-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("supplierId") int theId,
									Model theModel) {
		
		// get the supplier from the service
		Supplier theSupplier = supplierService.findById(theId);
		
		// set supplier as a model attribute to pre-populate the form
		theModel.addAttribute("supplier", theSupplier);
		
		// send over to our form
		return "/erpMenu/suppliers/supplier-form";			
	}
	
	
	@PostMapping("/save")
	public String saveSupplier(@ModelAttribute("supplier") Supplier newSupplier) {
		// save the supplier
		supplierService.save(newSupplier);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/suppliers/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("supplierId") int theId) {
		
		// delete the supplier
		supplierService.deleteById(theId);
		
		// redirect to /suppliers/list
		return "redirect:/suppliers/list";
		
	}
	
//	@GetMapping("/search")
//	public String delete(@RequestParam("supplierName") String theName,
//						 Model theModel) {
//		
//		// delete the supplier
//		List<Suppliers> theSuppliers = supplierService.searchBy(theName);
//		
//		// add to the spring model
//		theModel.addAttribute("suppliers", theSuppliers);
//		
//		// send to /supplier/list
//		return "/suppliers/list-suppliers";
//		
//	}
	
}

