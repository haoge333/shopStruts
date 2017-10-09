package com.xyy.service.imple;


import java.util.List;

import com.xyy.dao.ShoppingDao;
import com.xyy.enity.Shopping;
import com.xyy.service.ShoppingService;

public class ShoppingServiceImple implements ShoppingService{
	
	private ShoppingDao shoppingDao=new ShoppingDao();
	private Shopping shopping=new Shopping();

	//增加商品
	public void addShopping(Shopping shopping) {
		shoppingDao.addShopping(shopping);
	}

	//删除商品
	public void deleteShopping(Integer id) {
		shoppingDao.deleteShopping(id);
	}

	//通过id查询商品
	public Shopping findShoppingById(Integer id) {
		return shoppingDao.findShoppingById(id);
	}
	
	//修改商品
	public void updateShopping(Shopping shopping) {
		shoppingDao.updateShopping(shopping);
	}
	
	//商品信息列表
	public List<Shopping> listShopping() {
		return shoppingDao.listShopping();
	}


}
