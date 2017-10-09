package com.xyy.enity;

public class Address {
	private Integer id;
	private String addressName;
	private String phone;
	private String post;
	private Integer userId;
	
	
	public Address() {
		super();
	}


	public Address(Integer id, String addressName, String phone, String post,
			Integer userId) {
		super();
		this.id = id;
		this.addressName = addressName;
		this.phone = phone;
		this.post = post;
		this.userId = userId;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getAddressName() {
		return addressName;
	}


	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPost() {
		return post;
	}


	public void setPost(String post) {
		this.post = post;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	
}
