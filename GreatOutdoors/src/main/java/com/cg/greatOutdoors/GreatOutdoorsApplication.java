package com.cg.greatOutdoors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.greatOutdoors.entity.Product;
import com.cg.greatOutdoors.exception.ProductException;
import com.cg.greatOutdoors.service.ProductService;


@SpringBootApplication
public class GreatOutdoorsApplication {

	
	public static void main(String[] args) throws ProductException {
		SpringApplication.run(GreatOutdoorsApplication.class, args);
	}

}
