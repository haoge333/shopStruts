package com.xyy.service;

import java.util.List;

import com.xyy.dto.AddressDto;
import com.xyy.enity.Address;

public interface AddressService {

	public List<AddressDto> listAddressDto();

	public Address findAddressById(Integer id);

}
