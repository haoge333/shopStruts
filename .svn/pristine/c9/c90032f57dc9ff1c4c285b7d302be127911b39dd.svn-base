package com.xyy.dto;

import com.xyy.enity.Address;
import com.xyy.enity.Order;
import com.xyy.enity.User;

public class OrderDto extends Order{
	private User user;
	private Address address;
	public OrderDto() {
		super();
	}
	public OrderDto(Integer id, String orderNumber, Double totalPrice,
			Integer userId, Integer addressId, String orderDate, String status) {
		super(id,orderNumber, totalPrice,
				userId,addressId, orderDate, status);
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "orderDto [user=" + user + ", address=" + address + "]";
	}
	
}
