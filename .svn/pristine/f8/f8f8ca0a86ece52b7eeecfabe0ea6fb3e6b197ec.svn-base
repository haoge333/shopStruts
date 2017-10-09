package com.xyy.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.xyy.enity.Shopping;
import com.xyy.util.JdbcUtil;


public class ShoppingDao{

	//增加商品
	public void addShopping(Shopping shopping) {
		try {
			QueryRunner runner = new QueryRunner();
			String sql = "insert into t_shopping values(null,?,?,?,?,?,?,?)";

			Object[] params = { shopping.getName(), shopping.getPrice(),
					shopping.getBrand(), shopping.getCreateDate(),shopping.getDescription(),
					shopping.getCategoryName(),shopping.getImgsFileName()};

			runner.update(JdbcUtil.getConnection(), sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//删除商品
	public void deleteShopping(Integer id) {
		try {
			QueryRunner runner = new QueryRunner();
			String sql = "delete from t_shopping where id = ?";
			runner.update(JdbcUtil.getConnection(), sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//通过id查询商品
	public Shopping findShoppingById(Integer id) {
		Shopping shopping = null;
		try {
			QueryRunner runner = new QueryRunner();
			String sql = "select * from t_shopping where id = ?";

			shopping = runner.query(JdbcUtil.getConnection(), sql,
					new BeanHandler<Shopping>(Shopping.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shopping;
	}
	
	//修改商品
	public void updateShopping(Shopping shopping) {

		try {
			QueryRunner runner = new QueryRunner();
			String sql = "update t_shopping set name=?,price=?,brand=?,createdate=?,description=?,categoryName=?,imgsFileName=?  where id=?";

			Object[] params = {shopping.getName(), shopping.getPrice(),
					shopping.getBrand(), shopping.getCreateDate(),shopping.getDescription(),
					shopping.getCategoryName(), shopping.getImgsFileName(),shopping.getId()};

			runner.update(JdbcUtil.getConnection(), sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	//商品信息列表
	public List<Shopping> listShopping() {
		QueryRunner runner = new QueryRunner();
		List<Shopping> shopping=new ArrayList<Shopping>();
		try {
			String sql = "select * FROM t_shopping";
			shopping= runner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<Shopping>(Shopping.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shopping;
	}

}
