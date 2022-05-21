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

import com.salesERP.erp.entity.Customer;
import com.salesERP.erp.service.CustomerService;


@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	// add mapping for "/list"
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from db
		List<Customer> theCustomers = customerService.findAll();
		
		// add to the spring model
		theModel.addAttribute("customers", theCustomers);
		
		return "/erpMenu/customers/list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "/erpMenu/customers/customer-form";
	}
	
	@GetMapping("/showFormForAddSmall")
	public String showFormForAddSmall(Model theModel) {
		
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "/erpMenu/customers/small-customer-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
									Model theModel) {
		
		// get the customer from the service
		Customer theCustomer = customerService.findById(theId);
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		// send over to our form
		return "/erpMenu/customers/customer-form";			
	}
	
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the customer
		customerService.save(theCustomer);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/customers/list";
	}
	
	@PostMapping("/saveSmallCustomer")
	public String saveSmallCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the customer
		customerService.save(theCustomer);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/sales/showFormForAdd";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {
		
		// delete the customer
		customerService.deleteById(theId);
		
		// redirect to /customers/list
		return "redirect:/customers/list";
		
	}
	
//	@GetMapping("/search")
//	public String delete(@RequestParam("customerName") String theName,
//						 Model theModel) {
//		
//		// delete the customer
//		List<Customer> theCustomer = customerService.searchBy(theName);
//		
//		// add to the spring model
//		theModel.addAttribute("customers", theCustomer);
//		
//		// send to /customers/list
//		return "/erpMenu/customers/list-customers";
//		
//	}
	
}


















