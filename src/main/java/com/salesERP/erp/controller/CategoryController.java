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

import com.salesERP.erp.entity.Category;
import com.salesERP.erp.service.CategoryService;


@Controller
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	// add mapping for "/list"
	@GetMapping("/list")
	public String listCategories(Model theModel) {
		
		// get categories from db
		List<Category> theCategories = categoryService.findAll();
		
		// add to the spring model
		theModel.addAttribute("categories", theCategories);
		
		return "/erpMenu/products/categories/list-categories";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Category theCategory = new Category();
		
		theModel.addAttribute("category", theCategory);
		
		return "/erpMenu/products/categories/category-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("categoryId") int theId,
									Model theModel) {
		
		// get the category from the service
		Category theCategory = categoryService.findById(theId);
		
		// set category as a model attribute to pre-populate the form
		theModel.addAttribute("category", theCategory);
		
		// send over to our form
		return "/erpMenu/products/categories/category-form";			
	}
	
	
	@PostMapping("/save")
	public String saveCategory(@ModelAttribute("category") Category theCategory) {
		
		// save the category
		categoryService.save(theCategory);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/categories/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("categoryId") int theId) {
		
		// delete the category
		categoryService.deleteById(theId);
		
		// redirect to /categories/list
		return "redirect:/categories/list";
		
	}
	
	@GetMapping("/search")
	public String delete(@RequestParam("categoryName") String theName,
						 Model theModel) {
		
		// delete the category
		List<Category> theCategory = categoryService.searchBy(theName);
		
		// add to the spring model
		theModel.addAttribute("categories", theCategory);
		
		// send to /categories/list
		return "/erpMenu/categories/list-categories";
		
	}
	
}


















