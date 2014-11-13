package com.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Shop;


@Controller
public class JSONController {

	@RequestMapping(value="/jsonkoo", method = RequestMethod.GET)
	public @ResponseBody Shop getShopInJSON() {
		/* @ResponseBody(将处理完请求后返回的对象绑定到响应正文) */
		//测试数据
		Shop shop = new Shop();
		System.out.println("Shop......");
		shop.setName("lalala");
		shop.setStaffName(new String[]{"ML1", "ML2"});
	/*	返回去页面一个shop对象*/
		return shop;

	}
	
}
