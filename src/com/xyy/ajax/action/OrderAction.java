package com.xyy.ajax.action;

import java.util.List;

import com.google.gson.Gson;
import com.xyy.dto.OrderDto;
import com.xyy.enity.Order;
import com.xyy.enity.ShopItem;
import com.xyy.service.OrderService;
import com.xyy.service.imple.OrderServiceImple;

public class OrderAction {
	private ShopItem shopItem;
	private Order order;
	private OrderDto orderDto;
	private String result;
	private OrderService orderService = new OrderServiceImple();
			
	public ShopItem getShopItem() {
		return shopItem;
	}
	public void setShopItem(ShopItem shopItem) {
		this.shopItem = shopItem;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public OrderDto getOrderDto() {
		return orderDto;
	}
	public void setOrderDto(OrderDto orderDto) {
		this.orderDto = orderDto;
	}
	public String getResult() {
		return result;
	}
	/**
	 * 添加订单
	 * @return
	 */
	public String addOrder(){
		orderService.addOrder(order,this.shopItem.getId());
		this.result="ok";
		return "success";
	}
	/**
	 * 展示订单列表（组装订单展示类）
	 */
	public String orderShow(){
		List<OrderDto> orderDtos=orderService.listOrderDto();
		this.result=new Gson().toJson(orderDtos);
		return "success";
	}
	/**
	 * 支付订单
	 * @return
	 */
	public String payOrder(){
		orderService.updateOrder(this.order.getId());
		this.result="ok";
		return "success";
	}
	/**
	 * 支付订单,修改订单后返回此订单
	 * @return
	 */
	public String payOrderTwo(){
		Order order = orderService.updateOrderTwo(this.order.getId());
		this.result=new Gson().toJson(order);
		return "success";
	}
	/**
	 * 删除订单
	 * @return
	 */
	public String deleteOrder(){
		orderService.deleteOrder(this.order.getId());
		this.result="ok";
		return "success";
	}
	
}
