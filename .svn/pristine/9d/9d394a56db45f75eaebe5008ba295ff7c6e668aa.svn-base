package com.xyy.ajax.action;


import java.util.List;

import com.google.gson.Gson;
import com.xyy.enity.Shopping;
import com.xyy.service.ShoppingService;
import com.xyy.service.imple.ShoppingServiceImple;

public class ShopAjaxAction{
	private Shopping shopping;
	private ShoppingService shoppingService = new ShoppingServiceImple();
	private String result;
	
	public Shopping getShopping() {
		return shopping;
	}

	public void setShopping(Shopping shopping) {
		this.shopping = shopping;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	
	// 列表展示商品信息
	public String ajaxShopping() {
		List<Shopping> listShopping = shoppingService.listShopping();
		this.result=new Gson().toJson(listShopping);
		return "success";
	}

	//	通过id查询商品
	public String findShoppingById() {
		Shopping shopping = shoppingService.findShoppingById(this.shopping.getId());
		this.result=new Gson().toJson(shopping);
		return "success";
	}
	
	
}
