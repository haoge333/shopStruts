package com.xyy.service;

import java.util.List;

import com.xyy.enity.Shopping;

public interface ShoppingService {
	// 增加商品
	public void addShopping(Shopping shopping);

	// 删除商品
	public void deleteShopping(Integer id);

	// 通过id查询商品
	public Shopping findShoppingById(Integer id);

	// 修改商品
	public void updateShopping(Shopping shopping);

	// 商品信息列表
	public List<Shopping> listShopping();
	
}
