package com.xyy.enity;

import java.io.Serializable;
import java.sql.Connection;

public class ShopItem implements Serializable {

	private static final long serialVersionUID = 2018073346514745821L;
	
	private Integer id;
	private Integer shoppingId;    //商品编号
	private String  shoppingName;   //商品名称
	private Integer shopNumber;    //同个商品的数量
	private Double  discountPrice;         //单价
	private Integer userId;     //卖家编号
	private String inShopCar;     //是否在购物车中
	private Integer orderId;       //订单编号
	public ShopItem() {
		super();
	}
	public ShopItem(Integer id, Integer shoppingId, String shoppingName,
			Integer shopNumber, Double discountPrice, Integer userId,
			String inShopCar, Integer orderId) {
		super();
		this.id = id;
		this.shoppingId = shoppingId;
		this.shoppingName = shoppingName;
		this.shopNumber = shopNumber;
		this.discountPrice = discountPrice;
		this.userId = userId;
		this.inShopCar = inShopCar;
		this.orderId = orderId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getShoppingId() {
		return shoppingId;
	}
	public void setShoppingId(Integer shoppingId) {
		this.shoppingId = shoppingId;
	}
	public String getShoppingName() {
		return shoppingName;
	}
	public void setShoppingName(String shoppingName) {
		this.shoppingName = shoppingName;
	}
	public Integer getShopNumber() {
		return shopNumber;
	}
	public void setShopNumber(Integer shopNumber) {
		this.shopNumber = shopNumber;
	}
	public Double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getInShopCar() {
		return inShopCar;
	}
	public void setInShopCar(String inShopCar) {
		this.inShopCar = inShopCar;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "ShopItem [id=" + id + ", shoppingId=" + shoppingId
				+ ", shoppingName=" + shoppingName + ", shopNumber="
				+ shopNumber + ", discountPrice=" + discountPrice + ", userId="
				+ userId + ", inShopCar=" + inShopCar + ", orderId=" + orderId
				+ "]";
	}

	
	
}
