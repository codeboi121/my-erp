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

import com.salesERP.erp.entity.Sale;
import com.salesERP.erp.service.SaleService;


@Controller
@RequestMapping("/sales")
public class SaleController {

	@Autowired
	private SaleService saleService;
	
	// add mapping for dashboard link
	@GetMapping("/contents")
	public String dashBoardContents() {
		return "/erpMenu/sales/saleContents";
	}
		
	// add mapping for "/list"
	@GetMapping("/list")
	public String listSales(Model theModel) {
		
		// get sale from db
		List<Sale> theSales = saleService.findAll();
		
		// add to the spring model
		theModel.addAttribute("sales", theSales);
		
		return "/erpMenu/sales/list-sales";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Sale theSale = new Sale();
		theSale.setSaleBy("Admin User");
		
		//get the last record of the table and, set the seller's name and invoice number
		Sale prevSale=saleService.getLastRecord();
		theSale.setInvoiceNo(prevSale.getInvoiceNo()+1);
		
		
		theModel.addAttribute("sale", theSale);
		
		return "/erpMenu/sales/sale-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("saleId") int theId,
									Model theModel) {
		
		// get the sale from the service
		Sale theSale = saleService.findById(theId);
		
		// set sale as a model attribute to pre-populate the form
		theModel.addAttribute("sale", theSale);
		
		// send over to our form
		return "/erpMenu/sales/sale-form";			
	}
	
	
	@PostMapping("/save")
	public String saveSale(@ModelAttribute("sale") Sale newSale) {
		
		// save the sale
		saleService.save(newSale);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/sales/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("saleId") int theId) {
		
		// delete the sale
		saleService.deleteById(theId);
		
		// redirect to /sales/list
		return "redirect:/sales/list";
		
	}
	
//	@GetMapping("/search")
//	public String delete(@RequestParam("saleName") String theName,
//						 Model theModel) {
//		
//		// delete the sale
//		List<Sales> theSales = saleService.searchBy(theName);
//		
//		// add to the spring model
//		theModel.addAttribute("sales", theSales);
//		
//		// send to /sale/list
//		return "/sales/list-sales";
//		
//	}
	
}


















