package com.xyy.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xyy.enity.ShopItem;


public class ShopItemDao {
	//先通过shoppingId判断数据库中是否存在这个商品
	public ShopItem doHasShopping(Connection conn, Integer shoppingId) {
		QueryRunner runner = new QueryRunner();
		ShopItem shopItem=null;
			try {
				String sql = "select * from t_shopitem where shoppingId=? and inshopCar='在购物车里'";
				shopItem = runner.query(conn, sql, new BeanHandler<ShopItem>(ShopItem.class),shoppingId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return shopItem;
	}
	//如果购物项中没用此商品，则增加此商品
	public void addShopItem(Connection conn, ShopItem shopItemNew) {
		QueryRunner runner = new QueryRunner();
		try {
			String sql = "insert into t_shopitem values(null,?,?,?,?,?,?,0)";
			Object[] params = {shopItemNew.getShoppingId(),shopItemNew.getShoppingName(),shopItemNew.getShopNumber(),shopItemNew.getDiscountPrice(),shopItemNew.getUserId(),shopItemNew.getInShopCar()};
			runner.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//如果购物项中有此商品，则修改购物车中此商品的数量
	public void updateShopItem(Connection conn,ShopItem shopItem) {
		QueryRunner runner = new QueryRunner();
		try {
			String sql = "update t_shopitem set shopNumber=? where id=? ";	
			Object[] params = {shopItem.getShopNumber(),shopItem.getId()};
			runner.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//计算购物详单中所以商品的总数量
	public Integer shopTotalCount(Connection conn) {
		Integer totalCount = 0;
		try {
			QueryRunner runner = new QueryRunner();
			String sql = "select sum(shopNumber) from t_shopitem where inshopCar='在购物车里'";
			//得到 BigDecimal ，再转换为int
			BigDecimal b = runner.query(conn, sql, new ScalarHandler<BigDecimal>());
			if(b!=null){
				totalCount = b.intValue();
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCount;
	}

	public void deleteShopItem(Connection conn, Integer shopItemId) {
		try {
			QueryRunner runner = new QueryRunner();
			String sql = "delete from t_shopitem  where id=? ";
			runner.update(conn, sql, shopItemId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	//购物车中的商品提交订单后，增加一个订单号
	public void updateShopItemOrderId(Connection conn, Integer orderId, int i) {
		QueryRunner runner = new QueryRunner();
		try {
			String sql = "update t_shopitem set orderId=? , inshopCar='不在购物车里' where customeId=1 and inshopCar=1 ";
			runner.update(conn, sql, orderId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public ShopItem getShopItemById(Connection conn, Integer id) {
		ShopItem shopItem = null;
		try {
			QueryRunner runner = new QueryRunner();
			String sql = "select * from t_shopitem where id=? and inShopCar='在购物车里'";
			shopItem = runner.query(conn, sql, new BeanHandler<ShopItem>(ShopItem.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shopItem;
	}
	//购物车项列表
	public List<ShopItem> listShopItem(Connection conn) {
		QueryRunner runner = new QueryRunner();
		List<ShopItem> shopItems = null;
		try {
			String sql = "select * from t_shopitem where inShopCar='在购物车里'";
			shopItems = runner.query(conn, sql, new BeanListHandler<ShopItem>(ShopItem.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shopItems;
	}
	//通过商品id查询购物项
	public ShopItem getShopItemByShopId(Connection conn, Integer shoppingId) {
		ShopItem shopItem=null;
		QueryRunner runner = new QueryRunner();
		try {
			String sql = "select * from t_shopitem where shoppingId=? and inShopCar='在购物车里'";
			shopItem=runner.query(conn, sql, new BeanHandler<ShopItem>(ShopItem.class),shoppingId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shopItem;
	}
	//通过id查询购物项
	public ShopItem findShopItemById(Connection conn, Integer shopItemId) {
		QueryRunner runner = new QueryRunner();
		ShopItem shopItem =null;
		try {
			String sql="select * from t_shopitem where id=?";
			shopItem = runner.query(conn, sql, shopItemId, new BeanHandler<ShopItem>(ShopItem.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shopItem;
	}
	//当生成订单时,改变购物车商品状态，以及添加订单编号
	public void updateShopItemOrder(Connection conn, ShopItem shopItem) {
		QueryRunner runner = new QueryRunner();
		try {
			String sql="update t_shopitem set inshopCar=? ,orderId=? where id=?";
			Object[] param={shopItem.getInShopCar(),shopItem.getOrderId(),shopItem.getId()};
			runner.update(conn, sql, param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateShopItemPayOrder(Connection conn, ShopItem shopItem) {
		QueryRunner runner = new QueryRunner();
		try {
			String sql="update t_shopitem set inshopCar=? where orderId=?";
			Object[] param={shopItem.getInShopCar(),shopItem.getOrderId()};
			runner.update(conn, sql, param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteShopItemByOrderId(Connection conn, Integer orderid) {
		QueryRunner runner = new QueryRunner();
		try {
			String sql="delete from t_shopitem where orderId=?";
			runner.update(conn, sql, orderid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public ShopItem addShopItemTwo(Connection conn, ShopItem newShopItem) {
		QueryRunner runner = new QueryRunner();
		try {
			String sql = "insert into t_shopitem values(null,?,?,?,?,?,?,0)";
			Object[] params = {newShopItem.getShoppingId(),newShopItem.getShoppingName(),newShopItem.getShopNumber(),newShopItem.getDiscountPrice(),newShopItem.getUserId(),newShopItem.getInShopCar()};
			runner.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String id=null;
		try {
			String sql="select last_insert_ID";
			id= runner.query(conn, sql,  new ScalarHandler()).toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer shopItemId=Integer.parseInt(id);
		
		
		ShopItem shopItem = new ShopItemDao().findShopItemById(conn, shopItemId);
		return shopItem;
	}
	
	public ShopItem updateShopItemTwo(Connection conn, ShopItem shopItem) {
		QueryRunner runner = new QueryRunner();
		try {
			String sql = "update t_shopitem set shopNumber=? where id=? ";	
			Object[] params = {shopItem.getShopNumber(),shopItem.getId()};
			runner.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ShopItem newshopItem = new ShopItemDao().findShopItemById(conn, shopItem.getId());
		return newshopItem;
	}
	
	

}
