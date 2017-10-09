package com.xyy.ajax.action;

import java.util.List;

import com.google.gson.Gson;
import com.xyy.dto.AddressDto;
import com.xyy.enity.Address;
import com.xyy.enity.User;
import com.xyy.service.AddressService;
import com.xyy.service.imple.AddressServiceImple;

public class AddressAction {
	private Address address;
	private User user;
	private AddressDto addressDto;
	private String result;
	
	private AddressService addressService = new AddressServiceImple();
	
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
	public AddressDto getAddressDto() {
		return addressDto;
	}
	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}
	public String getResult() {
		return result;
	}
	/**
	 *地址展示类的展示
	 * @return
	 */
	public String listAddress() {
		 List<AddressDto> addressDtos= addressService.listAddressDto();
		 this.result=new Gson().toJson(addressDtos);
		return "success";
	}
	/**
	 * 通过id查询地址
	 */
	public String findAddressById(){
		Address address = addressService.findAddressById(this.address.getId());
		this.result=new Gson().toJson(address);
		return "success";
	}
	
}
