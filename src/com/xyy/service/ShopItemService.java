package com.xyy.service;

import java.util.List;

import com.xyy.dto.ShopItemDto;
import com.xyy.enity.ShopItem;

public interface ShopItemService {
    // 判断数据库中是否添加过这个商品
	public ShopItem doHasShopping(Integer shoppingId);
	//如果未曾添加此商品，则添加这个商品到购物详单中
	public void addShopItem(ShopItem shopItemNew);
	//如果已添加过此商品，则更改商品的数量
	public void updateShopItem(ShopItem shopItem);
	//得到购物详情单中所有商品的总数量
	public Integer shopTotalCount();
	//根据id获取购物项目
	public ShopItem getShopItemById(Integer id);
	//根据id删除购物项目，
	public void deleteShopItem(Integer id);
	//购物车中的商品提交订单后，修改购物车所在的订单号
	public void updateShopItemOrderId(Integer orderId, int i);
	//购物车展示
	public List<ShopItemDto> listShopItemDto();
	//通过商品的id查询购物项
	public ShopItem getShopItemByShopId(Integer shoppingId);
	//购物车欲生成订单展示
	public ShopItemDto shopItemOrderDto(Integer shopItemId, Integer addressId);
	
	public ShopItem addShopItemTwo(ShopItem newShopItem);
	
	public ShopItem updateShopItemTwo(ShopItem shopItem);

	


}
