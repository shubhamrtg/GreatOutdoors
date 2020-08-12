package com.cg.greatOutdoors.dao;

import java.util.List;

import com.cg.greatOutdoors.entity.Product;


public interface ProductDao {
	boolean addProduct(Product product);
	boolean editProduct(Product product);
	boolean deleteProduct(Product product);
	List<Product> displayAllProducts();
	Product viewProduct(long productId);
}
