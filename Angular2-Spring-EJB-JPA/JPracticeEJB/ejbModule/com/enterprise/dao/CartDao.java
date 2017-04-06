package com.enterprise.dao;

import javax.ejb.Local;

import com.enterprise.vo.ProductVo;


@Local
public interface CartDao {
	
	  void addProductToCart(ProductVo product);
	  
	  void checkOut();

	  void getProductToCart();
}
