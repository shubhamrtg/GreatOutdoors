package com.cg.greatOutdoors.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.greatOutdoors.controllers.LoggerInterceptor;
import com.cg.greatOutdoors.entity.Product;
import com.cg.greatOutdoors.exception.ProductException;
import com.cg.greatOutdoors.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductServiceTest {
	
	static Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
	
	@Autowired
	ProductService productService;

	@Rollback(false)
	@Test
	@DisplayName("Test for adding an product")
	public void addProductTest() throws ProductException
	{
		Product product=new Product(89, 200,"yellow","15cm","Willo","BSA",10,2,"Bat","open");
		assertEquals(true,productService.addProduct(product));
		
		product=new Product(89, 200,"green","15cm","KashmirWillo","Adidas",10,2,"Bat","open");
		assertEquals(false,productService.addProduct(product));
	}
	
	@Rollback(false)
	@Test
	@DisplayName("Test for editing a product")
	public void editProductTest() throws ProductException
	{
		Product product=new Product(85, 85,"pink","15cm","Willo","Kashmir",10,2,"Bat","open");
		assertEquals(true,productService.editProduct(product));
		
		product=new Product(88, 85,"pink","15cm","Willo","Kashmir",10,2,"Bat","open");
		assertEquals(false,productService.editProduct(product));
	}
	
	@Rollback(false)
	@Test
	@DisplayName("Test for deleting a product")
	public void deleteProductTest() throws ProductException
	{
		Product product=new Product(85, 200,"Red","60cm","EnglishWillo","Kashmir",10,2,"Bat","open");
		assertEquals(true,productService.deleteProduct(product));
		
		product=new Product(90, 200,"Red","60cm","EnglishWillo","Kashmir",10,2,"Bat","open");
		assertEquals(false,productService.deleteProduct(product));
	}
	
	@Rollback(false)
	@Test
	@DisplayName("Test for retrieving products")
	public void retrieveProductTest() throws ProductException
	{
		List<Product> list=productService.displayAllProducts();
		logger.info(list.toString());
		assertFalse(list.isEmpty());
		
		assertTrue(!list.isEmpty());
	}
	
}
