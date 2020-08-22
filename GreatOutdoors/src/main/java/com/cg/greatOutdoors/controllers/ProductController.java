package com.cg.greatOutdoors.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.greatOutdoors.entity.Product;
import com.cg.greatOutdoors.exception.ProductException;
import com.cg.greatOutdoors.service.ProductService;
@CrossOrigin(origins="*")
@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	
	
	//*********************** ALL PRODUCTS OPERATION*********************************
	/*
	 * This methods is used to insert Product data in database . It takes the data only in json Format 
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/addproduct",consumes="application/json")
	public String addProduct(@RequestBody Product product) throws ProductException
	{   productService.addProduct(product);
		return "Product Added Successfully";
	}
	
	/*
	 * This methods is used to edit a Product data in database . It takes the data only in json Format 
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/editproduct",consumes="application/json")
	public String editProduct(@RequestBody Product product) throws ProductException
	{   productService.editProduct(product);
		return "Product Edited Successfully";
	}
	
	/*
	 * This methods is used to delete a Product data in database . It takes the data only in json Format 
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/deleteproduct",consumes="application/json")
	public String deleteProduct(@RequestBody Product product) throws ProductException
	{   productService.deleteProduct(product);
		return "Product deleted Successfully";
	}
	
	/*
	 * This method will return the List of all the products available in database
     */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/product")
	public List displayAllProducts() throws ProductException
	{  
		return productService.displayAllProducts();
	}
	
}
	