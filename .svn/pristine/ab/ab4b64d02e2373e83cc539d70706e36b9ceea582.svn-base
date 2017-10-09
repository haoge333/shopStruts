package com.xyy.service.imple;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.xyy.dao.AddressDao;
import com.xyy.dao.ShopItemDao;
import com.xyy.dao.ShoppingDao;
import com.xyy.dao.UserDao;
import com.xyy.dto.ShopItemDto;
import com.xyy.enity.Address;
import com.xyy.enity.ShopItem;
import com.xyy.enity.Shopping;
import com.xyy.enity.User;
import com.xyy.service.ShopItemService;
import com.xyy.util.JdbcUtil;

public class ShopItemServiceImple implements ShopItemService {
	private ShopItemDao shopItemDao=new ShopItemDao();
	private Connection conn=JdbcUtil.getConnection();
	private ShoppingDao shoppingDao =new ShoppingDao();
	private AddressDao addressDao = new AddressDao();
	private UserDao userDao =new  UserDao();
	
	@Override
	public ShopItem doHasShopping(Integer shoppingId) {

		return shopItemDao.doHasShopping(conn,shoppingId);
	}

	@Override
	public void addShopItem(ShopItem shopItemNew) {
		shopItemDao.addShopItem(conn,shopItemNew);
	}

	@Override
	public void updateShopItem(ShopItem shopItem) {
		shopItemDao.updateShopItem(conn,shopItem);	
	}

	@Override
	public Integer shopTotalCount() {
		// TODO Auto-generated method stub
		return shopItemDao.shopTotalCount(conn);
	}
	
	@Override
	public ShopItem getShopItemById(Integer id) {
	
		return shopItemDao.getShopItemById(conn,id);
	}

	@Override
	public void deleteShopItem(Integer shopItemId) {
		shopItemDao.deleteShopItem(conn,shopItemId);
	}

	@Override
	public void updateShopItemOrderId(Integer orderId, int i) {
		shopItemDao.updateShopItemOrderId(conn,orderId, i);
		
	}

	/**
	 * 购物车展示1：商品加入购物车时列表购物车
	 *          shopping + shopItem
	 *        
	 */
	@Override
	public List<ShopItemDto> listShopItemDto() {
		List<ShopItemDto> shopItemDtos=new ArrayList<ShopItemDto>();
		List<ShopItem> shopItems = shopItemDao.listShopItem(conn);
		for (ShopItem shopItem : shopItems) {
			Shopping shopping = shoppingDao.findShoppingById(shopItem.getShoppingId());
			ShopItemDto shopItemDto= new ShopItemDto(shopItem.getId(), shopItem.getShoppingId(), shopItem.getShoppingName(), shopItem.getShopNumber(), shopItem.getDiscountPrice(), shopItem.getUserId(), shopItem.getInShopCar(), shopItem.getOrderId());
			shopItemDto.setShopping(shopping);
			shopItemDtos.add(shopItemDto);
		}
		return shopItemDtos;
	}
	
	
	/**
	 * 购物车展示2：商品加入购物车时列表购物车
	 *          shopping + shopItem + address + user
	 *        
	 */
	@Override
	public ShopItemDto shopItemOrderDto(Integer shopItemId, Integer addressId) {
		ShopItem shopItem =shopItemDao.findShopItemById(conn,shopItemId);
		Address address = addressDao.findAddressById(conn, addressId);
		Shopping shopping =shoppingDao.findShoppingById(shopItem.getShoppingId());
		User user = userDao.findUsrById(conn,address.getUserId());
	
		ShopItemDto shopItemOrderDto =new ShopItemDto(shopItem.getId(), shopItem.getShoppingId(), shopItem.getShoppingName(), shopItem.getShopNumber(), shopItem.getDiscountPrice(), shopItem.getUserId(), shopItem.getInShopCar(), shopItem.getOrderId());
		shopItemOrderDto.setAddress(address);
		shopItemOrderDto.setShopping(shopping);
		shopItemOrderDto.setUser(user);
		return shopItemOrderDto;
	}

	@Override
	public ShopItem getShopItemByShopId(Integer shoppingId) {
		return shopItemDao.getShopItemByShopId(conn,shoppingId);
	}

	@Override
	public ShopItem addShopItemTwo(ShopItem newShopItem) {
		return shopItemDao.addShopItemTwo(conn,newShopItem);
	}

	@Override
	public ShopItem updateShopItemTwo(ShopItem shopItem) {
		
		return shopItemDao.updateShopItemTwo(conn, shopItem);
	}

	



}
