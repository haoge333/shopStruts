package com.xyy.service.imple;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.xyy.dao.AddressDao;
import com.xyy.dao.UserDao;
import com.xyy.dto.AddressDto;
import com.xyy.enity.Address;
import com.xyy.enity.User;
import com.xyy.service.AddressService;
import com.xyy.util.JdbcUtil;

public class AddressServiceImple implements AddressService {
	private Connection conn=JdbcUtil.getConnection();
	private AddressDao addressDao = new AddressDao();
	private UserDao userDao = new UserDao();
	/**
	 * 地址展示类，用于结算时选择收获地址
	 */
	@Override
	public List<AddressDto> listAddressDto() {
		List<Address> addresses = addressDao.listAddress(conn);
		List<AddressDto> addressDtos = new ArrayList<AddressDto>();
		
		for (Address address : addresses) {
			User user = userDao.findUserById( conn,address.getUserId());
			AddressDto addressDto=new AddressDto(address.getId(), address.getAddressName(),
					address.getPhone(), address.getPost(), address.getUserId());
			addressDto.setUser(user);
			addressDtos.add(addressDto);
		}
		return addressDtos;
	}
	/**
	 * 通过id查询地址
	 */
	@Override
	public Address findAddressById(Integer id) {
		Address address = addressDao.findAddressById(conn,id);
		return address;
	}

}
