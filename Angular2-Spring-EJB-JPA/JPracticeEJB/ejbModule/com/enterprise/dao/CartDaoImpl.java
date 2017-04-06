package com.enterprise.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.enterprise.entity.Product;
import com.enterprise.vo.ProductVo;

@Stateless
public class CartDaoImpl implements CartDao {

	@PersistenceContext
	private EntityManager entityManager;

	private List<ProductVo> products;

	@Override
	public void addProductToCart(ProductVo product) {
		Product prd = new Product();
		prd.setType(product.getType());
		entityManager.persist(prd);

	}

	@Override
	// @TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void checkOut() {
		for (ProductVo product : products) {
			Product prd = new Product();
			prd.setType(product.getType());
			entityManager.persist(prd);
		}
		products.clear();
	}

	@Override
	public void getProductToCart() {
		for (ProductVo p : products) {
			System.out.println("----------- " + p.toString());
		}
	}

}
