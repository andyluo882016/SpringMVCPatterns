package com.web.spring.orm.dao;
import com.web.spring.orm.model.Product;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
 
import org.springframework.stereotype.Component;
 
@Component
public class ProductDao {

	@PersistenceContext
	private EntityManager em;

	public void persist(Product product) {
		em.persist(product);
	}

	@SuppressWarnings("unchecked")
	public List<Product> findAll() {
		return em.createQuery("SELECT p FROM Product p").getResultList();
	}
}
