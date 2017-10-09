package com.xyy.dto;

import com.xyy.enity.Address;
import com.xyy.enity.User;

public class AddressDto extends Address{
	private User user;
	
	public AddressDto() {
		super();
	}

	public AddressDto(Integer id, String addressName, String phone, String post,
			Integer userId) {
		super(id,addressName,phone,post,userId);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	

	
}
