package com.xyy.service.imple;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.xyy.dao.AddressDao;
import com.xyy.dao.OrderDao;
import com.xyy.dao.ShopItemDao;
import com.xyy.dao.UserDao;
import com.xyy.dto.OrderDto;
import com.xyy.enity.Address;
import com.xyy.enity.Order;
import com.xyy.enity.ShopItem;
import com.xyy.enity.User;
import com.xyy.service.OrderService;
import com.xyy.util.JdbcUtil;

public class OrderServiceImple implements OrderService {
	private OrderDao orderDao= new OrderDao();
	private UserDao userDao=new UserDao();
	private AddressDao addressDao =new AddressDao();
	private Connection conn=JdbcUtil.getConnection();
	private ShopItemDao  shopItemDao = new ShopItemDao();
	private ShopItem shopItem =new ShopItem();
	/**
	 * 添加订单：
	 *      1：在支付前，没有订单交易流水号
	 *      2：在支付前，订单状态为“订单未支付”
	 *      3:把订单编号给shopItem中的orderId
	 *      4:修改购物车商品状态为"已提交给订单"
	 */
	@Override
	public void addOrder(Order order,Integer shopItemId) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String orderDate = sdf.format(new Date());
		order.setOrderDate(orderDate);
		order.setStatus("订单未支付");
		order.setOrderNumber(null);
		Integer orderId=orderDao.addOrder(conn,order);

		shopItem.setOrderId(orderId);
		shopItem.setInShopCar("已提交给订单");
		shopItem.setId(shopItemId);
		shopItemDao.updateShopItemOrder(conn, this.shopItem);
		
	}
	/**
	 * 订单列表展示，组装订单展示类
	 *     order+user+address
	 */
	@Override
	public List<OrderDto> listOrderDto() {
		List<OrderDto> orderDtos=new ArrayList<OrderDto>();
		List<Order> orders = orderDao.listOrder(conn);
		OrderDto orderDto=null;
		for (Order order : orders) {
			User user=userDao.findUserById(conn,order.getUserId());
			Address address=addressDao.findAddressById(conn,order.getAddressId());
			orderDto=new OrderDto(order.getId(), order.getOrderNumber(), order.getTotalPrice(), order.getUserId(), 
					order.getAddressId(), order.getOrderDate(), order.getStatus());
			orderDto.setAddress(address);
			orderDto.setUser(user);
			orderDtos.add(orderDto);
		}
		return orderDtos;
	}
	/**
	 * 支付订单：
	 *      1:添加交易流水号；
	 *      2:修改订单状态为"订单已支付"；
	 *      3:购物车商品状态改为"商品已购买"
	 */
	@Override
	public void updateOrder(Integer id) {
		Order order=orderDao.findOrderById(conn,id);
	    String orderNumber = UUID.randomUUID().toString();
	    order.setOrderNumber(orderNumber);
	    order.setStatus("订单已支付");
	    orderDao.updateOrder(conn,order);
	    
	    shopItem.setInShopCar("商品已购买");
	    shopItem.setOrderId(order.getId());
	    shopItemDao.updateShopItemPayOrder(conn, shopItem);
	    
	}
	/**
	 * 删除订单：
	 * 		1：首先删除购物项中匹配orderid的购物项
	 * 		2：然后删除订单
	 */
	@Override
	public void deleteOrder(Integer orderid) {
		shopItemDao.deleteShopItemByOrderId(conn,orderid);
		orderDao.deleteOrderById(conn,orderid);
	}
	
	@Override
	public Order updateOrderTwo(Integer orderId) {
		Order order=orderDao.findOrderById(conn,orderId);
	    String orderNumber = UUID.randomUUID().toString();
	    order.setOrderNumber(orderNumber);
	    order.setStatus("订单已支付");
	    orderDao.updateOrder(conn,order);
	    shopItem.setInShopCar("商品已购买");
	    shopItem.setOrderId(order.getId());
	    shopItemDao.updateShopItemPayOrder(conn, shopItem);
		return  order;
	}

	
}
