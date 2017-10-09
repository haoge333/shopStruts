package com.xyy.dto;

import com.xyy.enity.Address;
import com.xyy.enity.ShopItem;
import com.xyy.enity.Shopping;
import com.xyy.enity.User;

public class ShopItemDto extends ShopItem{

	private static final long serialVersionUID = 54684646844L;
	private  Shopping shopping;
	private  Address address;
	private   User user;

	public ShopItemDto() {
		super();
	}

	public ShopItemDto(Integer id, Integer shoppingId, String shoppingName,
			Integer shopNumber, Double discountPrice, Integer userId,
			String inShopCar, Integer orderId) {
		super(id,shoppingId,shoppingName,
				shopNumber,discountPrice,userId,
				inShopCar,orderId);

	}

	public Shopping getShopping() {
		return shopping;
	}

	public void setShopping(Shopping shopping) {
		this.shopping = shopping;
	}

	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ShopItemDto [shopping=" + shopping + "]";
	}
}
