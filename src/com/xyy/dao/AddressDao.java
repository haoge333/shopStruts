package com.xyy.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.xyy.enity.Address;

public class AddressDao {
	/**
	 * 地址列表
	 */
	public List<Address> listAddress(Connection conn) {
		QueryRunner runner = new QueryRunner();
		List<Address> Address=null;
		try {
			String sql="select * from t_address";
			Address = runner.query(conn, sql, new BeanListHandler<Address>(Address.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Address;
	}
	/**
	 * 通过id查询地址
	 */
	public Address findAddressById(Connection conn, Integer id) {
		QueryRunner runner = new QueryRunner();
		Address address = null;
		try {
			String sql="select * from t_address where id=?";
			address = runner.query(conn, sql, id, new BeanHandler<Address>(Address.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return address;
	}
}
