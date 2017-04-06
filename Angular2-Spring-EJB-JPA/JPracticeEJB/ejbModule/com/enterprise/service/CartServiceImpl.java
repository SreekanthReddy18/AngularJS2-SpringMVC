package com.enterprise.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.enterprise.dao.CartDao;
import com.enterprise.vo.ProductVo;

@Stateless
public class CartServiceImpl implements CartService {

	@EJB
	CartDao cart;

	@Override
	public void addProductToCart(ProductVo product) {
		cart.addProductToCart(product);

	}

	@Override
	public void checkOut() {
		cart.checkOut();

	}

	@Override
	public void getProductToCart() {
		cart.getProductToCart();
	}

}
