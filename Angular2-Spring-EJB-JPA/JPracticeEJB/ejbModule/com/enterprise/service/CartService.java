package com.enterprise.service;

import javax.ejb.Local;

import com.enterprise.vo.ProductVo;

@Local
public interface CartService {
	
	  void addProductToCart(ProductVo product);
	  
	  void checkOut();

	  void getProductToCart();
}