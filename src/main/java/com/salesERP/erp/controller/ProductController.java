package com.salesERP.erp.controller;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import com.salesERP.erp.entity.Product;
import com.salesERP.erp.entity.Supplier;
import com.salesERP.erp.entity.Unit;
import com.salesERP.erp.service.CategoryService;
import com.salesERP.erp.service.ProductService;
import com.salesERP.erp.service.SupplierService;
import com.salesERP.erp.service.UnitService;


@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private UnitService unitService;
	@Autowired
	private SupplierService supplierService;
	
	// add mapping for product contents
	@GetMapping("/contents")
	public String dashBoardContents() {
		return "/erpMenu/products/productContents";
	}
		
	// add mapping for "/list"
	@GetMapping("/list")
	public String listProducts(Model theModel) {
		
		// get products from db
		List<Product> theProducts = productService.findAll();
		
		//converting the byteStream to images
		for (Product product : theProducts) {
			byteStreamToImage(product.getProductName(),product.getImage());
		}
		
		// add to the spring model
		theModel.addAttribute("products", theProducts);
		
		return "/erpMenu/products/list-products";
	}
	
	public void byteStreamToImage(String productName,byte[] image) {
		//logic below works in local server
		String imageDestinationPath="O:\\eclipse 2021 june version workplace\\erp\\src\\main\\resources\\static\\images\\"+productName+".png";
		
		File file=new File(imageDestinationPath);
		if(!file.exists())
		{
			try {
				FileOutputStream fos=new FileOutputStream(imageDestinationPath);
				fos.write(image);
				fos.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		//get all the categories ,units and suppliers from their respective tables
		List<Category> categories= categoryService.findAll();
		List<Unit> units=unitService.findAll();
		List<Supplier> suppliers=supplierService.findAll();
		// create model attribute to bind form data
		Product theProduct = new Product();
		
		theModel.addAttribute("product", theProduct);
		//add the categories and units into the model
		theModel.addAttribute("categories", categories);
		theModel.addAttribute("units", units);
		theModel.addAttribute("suppliers", suppliers);
		
		return "/erpMenu/products/product-form";
	}
	
	

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId") int theId,
									Model theModel) {
		
		// get the product from the service
		Product theProduct = productService.findById(theId);
		
		// set product as a model attribute to pre-populate the form
		theModel.addAttribute("product", theProduct);
		
		// send over to our form
		return "/erpMenu/products/product-form";			
	}
	
	
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product") Product theProduct) {
		//converting the image to byte stream to store in db
		System.out.println(theProduct.getFormImage());
		//bbyteStreamToImage(theProduct.getProductName(),theProduct.getFormImage());
	//	imageToByteStream(theProduct.getFormImage());
		// save the product
		productService.save(theProduct);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/products/list";
	}
	
//	public void bbyteStreamToImage(String productName,byte[] image) {
//		//logic below works in local server
//		String imageDestinationPath="O:\\eclipse 2021 june version workplace\\erp\\src\\main\\resources\\static\\imagesFromForm\\"+productName+".png";
//		
//		File file=new File(imageDestinationPath);
//		if(!file.exists())
//		{
//			try {
//				FileOutputStream fos=new FileOutputStream(imageDestinationPath);
//				fos.write(image);
//				fos.close();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
	
//	public void imageToByteStream(byte[] formImage) {
//		//logic below works in local server
//		String imageDestinationPath="O:\\eclipse 2021 june version workplace\\erp\\src\\main\\resources\\static\\images\\"+productName+".png";
//		
//		File file=new File(imageDestinationPath);
//		if(!file.exists())
//		{
//			try {
//				FileOutputStream fos=new FileOutputStream(imageDestinationPath);
//				fos.write(image);
//				fos.close();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
	
	
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("productId") int theId) {
		
		// delete the product
		productService.deleteById(theId);
		
		// redirect to /products/list
		return "redirect:/products/list";
		
	}
	
	@GetMapping("/search")
	public String delete(@RequestParam("productName") String theName,
						 Model theModel) {
		
		// delete the product
		List<Product> theProduct = productService.searchBy(theName);
		
		// add to the spring model
		theModel.addAttribute("products", theProduct);
		
		// send to /products/list
		return "/erpMenu/products/list-products";
		
	}
	
}

