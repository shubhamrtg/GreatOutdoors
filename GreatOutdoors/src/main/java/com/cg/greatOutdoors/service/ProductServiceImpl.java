package com.cg.greatOutdoors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.greatOutdoors.dao.ProductDao;
import com.cg.greatOutdoors.entity.Product;

import com.cg.greatOutdoors.exception.ProductException;

@Service("ProductService")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public boolean addProduct(Product product) throws ProductException {
		boolean status=false;
		if(productDao.viewProduct(product.getProductId())==null)
		{
			status=productDao.addProduct(product);
			return status;
		}
		return status;
	}

	@Override
	public boolean editProduct(Product product) throws ProductException {
		boolean status=false;
		if(productDao.viewProduct(product.getProductId())!=null)
		{
			status=productDao.editProduct(product);
		} 
		return status;
	}

	@Override
	public boolean deleteProduct(Product product) throws ProductException {
		boolean status=false;
		if(productDao.viewProduct(product.getProductId())!=null)
		{
			product.setStatus("close");
			status=productDao.deleteProduct(product);
		} 
		return status;
	}
	
	@Override
	public List<Product> displayAllProducts() throws ProductException {

		List<Product> productList =productDao.displayAllProducts();
		if (productList.isEmpty()) {
			throw new ProductException("Product List is Empty");
		} 
		return productList;
	}

}
