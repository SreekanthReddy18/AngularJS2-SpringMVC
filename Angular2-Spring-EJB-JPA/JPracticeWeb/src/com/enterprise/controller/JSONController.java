package com.enterprise.controller;

import javax.naming.NamingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.enterprise.locator.EksServiceLocator;
import com.enterprise.model.Shop;
import com.enterprise.service.CartService;
import com.enterprise.service.CartServiceImpl;
import com.enterprise.vo.ProductVo;

@Controller
// @RequestMapping("/kfc/brands")
public class JSONController {

	// @RequestMapping(value = "{name}", method = RequestMethod.GET)
	@RequestMapping(value = "/getProduct/{name}", method = RequestMethod.GET)
	@ResponseBody
	public Shop getShopInJSON(@PathVariable String name) {

		Shop shop = new Shop();
		shop.setName(name);
		shop.setStaffName(new String[] { "mkyong1", "mkyong2" });

		return shop;

	}

	@RequestMapping(value = "/saveProduct/{name}", method = RequestMethod.GET)
	public void getProduct(@PathVariable String name) throws NamingException {

		Shop shop = new Shop();
		shop.setName(name);

		ModelAndView mv = new ModelAndView();

		ProductVo p = new ProductVo();
		p.setType("hurray");

		EksServiceLocator<CartService> e = new EksServiceLocator<CartService>();
		CartService cartServiceImpl = e.getEksService(CartServiceImpl.class
				.getSimpleName());
		cartServiceImpl.addProductToCart(p);

		// mv.setViewName("/Hello");
		// return mv;
	}
}