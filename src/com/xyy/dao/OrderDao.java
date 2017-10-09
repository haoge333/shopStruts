package com.xyy.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xyy.enity.Order;

public class OrderDao{

	public Integer addOrder(Connection conn, Order order) {
		QueryRunner runner=new QueryRunner();
		Integer orderId=null;
		try {
			String sql="insert into t_order values (null,?,?,?,?,?,?)";
			Object[] param={order.getOrderNumber(),order.getTotalPrice(),order.getUserId(),order.getAddressId(),order.getOrderDate(),order.getStatus()};
			runner.update(conn, sql, param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String idd=null;
		try {
			String sql="select last_insert_ID()";
			idd=runner.query(conn, sql, new ScalarHandler()).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		orderId=Integer.parseInt(idd);
		return orderId;
		
	}

	public List<Order> listOrder(Connection conn) {
		QueryRunner runner=new QueryRunner();
		List<Order> orders=null;
		try {
			String sql="select * from t_order";
			orders = runner.query(conn, sql, new BeanListHandler<Order>(Order.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	public Order findOrderById(Connection conn, Integer id) {
		QueryRunner runner=new QueryRunner();
		Order order=null;
		try {
			String sql="select * from t_order where id=?";
			order = runner.query(conn, sql, id, new BeanHandler<Order>(Order.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

	public void updateOrder(Connection conn, Order order) {
		QueryRunner runner=new QueryRunner();
		try {
			String sql="update t_order set orderNumber=? ,status=? where id=?";
			Object[] param={order.getOrderNumber(),order.getStatus(),order.getId()};
			runner.update(conn, sql, param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteOrderById(Connection conn,Integer orderid) {
		QueryRunner runner=new QueryRunner();
		try {
			String sql="delete from t_order where id=?";
			runner.update(conn, sql, orderid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
