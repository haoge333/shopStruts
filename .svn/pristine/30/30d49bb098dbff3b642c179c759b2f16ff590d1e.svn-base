package com.xyy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * 提供获取数据库连接，和关闭资源的方法
 * @author Administrator
 *
 */
public class JdbcUtil {
	
	
	public static Connection getConnection(){
		Connection con = null;
		try {
			
			ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
			
			String driver = bundle.getString("driver");
			Class.forName(driver);
			String userName = bundle.getString("userName");
			String password = bundle.getString("password");
			String url = bundle.getString("url");
			
			con = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(Connection c, PreparedStatement p) {
		close(c, p, null, null);
	}

	public static void close(Connection c, PreparedStatement p, ResultSet r) {
		close(c, p, r, null);
	}

	public static void close(Connection c, Statement st, ResultSet r) {
		close(c, null, r, st);
	}

	/**
	 * 关闭资源
	 * 
	 * @param c
	 *            Connection
	 * @param p
	 *            PreparedStatement
	 * @param r
	 *            ResultSet
	 */
	public static void close(Connection c, PreparedStatement p, ResultSet r,Statement st) {
		if (r != null) {
			try {
				r.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (p != null) {
			try {
				p.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		System.out.println(getConnection());
	}

	

}
