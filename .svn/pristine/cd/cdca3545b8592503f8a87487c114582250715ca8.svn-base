package com.xyy.ajax.action;

import java.util.List;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.xyy.dto.ShopItemDto;
import com.xyy.enity.ShopItem;
import com.xyy.enity.Shopping;
import com.xyy.enity.User;
import com.xyy.service.ShopItemService;
import com.xyy.service.ShoppingService;
import com.xyy.service.imple.ShopItemServiceImple;
import com.xyy.service.imple.ShoppingServiceImple;

public class ShopItemAction{
	
	private ShopItem shopItem;
	private ShopItemDto shopItemDto;

	private String result;
	
	public String getResult() {
		return result;
	}
	private ShopItemService shopItemService = new ShopItemServiceImple();

	private ShoppingService shoppingService = new ShoppingServiceImple();
	
	public ShopItem getShopItem() {
		return shopItem;
	}
	public void setShopItem(ShopItem shopItem) {
		this.shopItem = shopItem;
	}
	
	public ShopItemDto getShopItemDto() {
		return shopItemDto;
	}
	public void setShopItemDto(ShopItemDto shopItemDto) {
		this.shopItemDto = shopItemDto;
	}
	/**
	 * 增加购物项
	 * 1：首先根据商品的id判断购物项中是否存在此商品
	 *    a:如果不存在，则在购物车中增加这个商品；
	 *    b:如果购物车中存在这个商品，则给商品数量加1
	 * 2：在进行操作1的同时，应该根据商品id查询此商品，
	 *   用来组建购物项对象 
	 */
	public String addShopItem(){
		ShopItem shopItem = shopItemService.doHasShopping(this.shopItem.getShoppingId());
		Shopping shopping = shoppingService.findShoppingById(this.shopItem.getShoppingId());
		User user=(User) ActionContext.getContext().getSession().get("user");
		if(shopItem==null){
			ShopItem newShopItem=new ShopItem(-1, shopping.getId(), shopping.getName(), 1, 
					                          shopping.getPrice(), user.getId(), "在购物车里", null);
			shopItemService.addShopItem(newShopItem);
		}else{
			shopItem.setShopNumber(shopItem.getShopNumber() + 1);
			shopItemService.updateShopItem(shopItem);
		}
		result="ok";
		return "success";
	}
	/**
	 * 增加购物项：
	 * 不管购物车中有没有这个商品，要么添加购物项，要么增加数量
	 *     总之最后都要返回这个购物项！
	 */
	public String addShopItemTwo(){
		ShopItem shopItem = shopItemService.doHasShopping(this.shopItem.getShoppingId());
		Shopping shopping = shoppingService.findShoppingById(this.shopItem.getShoppingId());
		User user=(User) ActionContext.getContext().getSession().get("user");
		ShopItem shopItem1=null;
		if(shopItem==null){
			ShopItem newShopItem=new ShopItem(-1, shopping.getId(), shopping.getName(), 1, 
					                          shopping.getPrice(), user.getId(), "在购物车里", null);
			shopItem1 =shopItemService.addShopItemTwo(newShopItem);
		}else{
			shopItem.setShopNumber(shopItem.getShopNumber() + 1);
			shopItem1 =shopItemService.updateShopItemTwo(shopItem);
		}
		result=new Gson().toJson(shopItem1);
		return "success";
	}
	/**
	 * 获取购物车总数量
	 * 1：inshopCar="在购物车里";
	 * @return
	 */
	public String shopTotalCount(){
		Integer shopTotalCount = shopItemService.shopTotalCount();
		result=shopTotalCount+"";
		return "success";
	}
	
	/**
	 * 获取购物车中的商品，用来展示购物车
	 * 1：inshopCar="在购物车里";
	 * @return
	 */
	public String shopCarShow(){
		List<ShopItemDto> shopItemDtos = shopItemService.listShopItemDto();
		result=new Gson().toJson(shopItemDtos);
		return "success";
	}
	
	/**
	 * 减少时，先通过商品id查找购物项
	 * 1:通过购物项可知商品数量
	 *    a:数量=1时，直接删除购物项目
	 *    b:数量>1时，商品数量-1
	 * @return
	 */
	public String reduceShopItem(){
		ShopItem shopItem = shopItemService.getShopItemByShopId(this.shopItem.getShoppingId());
		
		if (shopItem.getShopNumber() - 1 <= 0) {
			shopItemService.deleteShopItem(shopItem.getId());
		} else {
			shopItem.setShopNumber(shopItem.getShopNumber() - 1);
			shopItemService.updateShopItem(shopItem);
		}
		result="ok";
		return "success";
	}
	
	/**
	 * 加入地址，准备生成订单
	 */
	public String createOrder(){
		ShopItemDto shopItemOrderDto = shopItemService.shopItemOrderDto(this.shopItem.getId(),this.shopItemDto.getAddress().getId());
		result=new Gson().toJson(shopItemOrderDto);
		return "success";
	}
	public String shopCarToOrder(){
		return "success";
	}
	
	/**
	 * 把购物项中的某项完全删除
	 * @return
	 */
	public String delete(){
		shopItemService.deleteShopItem(this.shopItem.getId());
		result="ok";
		return "success";
	}
	
}
