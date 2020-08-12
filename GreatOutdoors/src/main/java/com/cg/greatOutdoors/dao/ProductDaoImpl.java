package com.cg.greatOutdoors.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.greatOutdoors.entity.Product;

@Repository("ProductDao")
@Transactional
public class ProductDaoImpl implements ProductDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean addProduct(Product product) {
		
		entityManager.persist(product);
		return true;
	}

	@Override
	public boolean editProduct(Product product) {
		entityManager.merge(product);
		return true;
	}

	@Override
	public boolean deleteProduct(Product product) {
		entityManager.merge(product);
		return true;
	}

	@Override
	public List<Product> displayAllProducts() {		
		String getProductQuery = "SELECT products FROM Product products WHERE status='open'";
		TypedQuery<Product> query = entityManager.createQuery(getProductQuery, Product.class);

		return query.getResultList();

	}

	@Override
	public Product viewProduct(long productId) {
		return entityManager.find(Product.class,productId);
	}
}
