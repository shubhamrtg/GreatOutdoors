package com.cg.greatOutdoors.service;

import java.util.List;

import com.cg.greatOutdoors.entity.Product;
import com.cg.greatOutdoors.exception.ProductException;


public interface ProductService {
	boolean addProduct(Product product) throws ProductException;
	boolean editProduct(Product product) throws ProductException;
	boolean deleteProduct(Product product) throws ProductException;
	List<Product> displayAllProducts() throws ProductException;
}
