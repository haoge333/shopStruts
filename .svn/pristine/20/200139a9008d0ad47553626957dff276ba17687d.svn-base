package com.xyy.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xyy.enity.User;
import com.xyy.util.JdbcUtil;

public class UserDao {
	//登录查询
	public User loginCheck(User user){
		User loginUser=null;
		try {
			QueryRunner runner=new QueryRunner();
			String sql="select * from t_user where name=? and password=?";
			Object[] param={user.getName(),user.getPassword()};
			loginUser=runner.query(JdbcUtil.getConnection(), sql,param,new BeanHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginUser;	
	}

	//列表展示信息
	public List<User> listUser(String searchName){
		List<User> users=new ArrayList<User>();
		try {
			QueryRunner runner=new QueryRunner();
			String sql="select * from t_user where 1=1 ";
			if(searchName!=null && !"".equals(searchName)){
				sql+=" and name like '%"+searchName+"%'";
			}
			users=runner.query(JdbcUtil.getConnection(), sql,new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;	
	}
	
	//分页展示信息
	public Map<String, Object> pageUser(Integer pageIndex, Integer pageSize, String searchName) {
		Map<String, Object> map=new HashMap<String, Object>();
		Integer pageStart = pageSize * (pageIndex - 1);
		QueryRunner runner=new QueryRunner();
		List<User> pageUser=new ArrayList<User>();
		Connection conn=JdbcUtil.getConnection();
		Integer totalRecord=null;
		try {
			String sql="select * from t_user where 1=1 ";
			if(searchName!=null && !"".equals(searchName)){
				sql+=" and name like '%"+searchName+"%'";
			}
			sql+=" limit ?,?";
			Object[] params={pageStart,pageSize};
			pageUser = runner.query(conn, sql, params, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		try {
			String sql1="select count(*) from t_user where 1=1 ";
			if(searchName!=null && !"".equals(searchName)){
				sql1+=" and name like '%"+searchName+"%'";
			}
			long total = runner.query(conn, sql1, new ScalarHandler<Long>());
			totalRecord=(int)total;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Integer totalPage=totalRecord%pageSize==0? totalRecord/pageSize :totalRecord/pageSize+1 ;
		map.put("pageUser", pageUser);
		map.put("totalPage", totalPage);
		map.put("pageIndex", pageIndex);
		map.put("pageSize", pageSize);
		map.put("totalRecord", totalRecord);
		return map;
	}
	
	//根据id查询用户
	public User findUserById(Connection conn, Integer id){
		User user=null;
		try {
			QueryRunner runner=new QueryRunner();
			String sql="select * from t_user where id=?";
			user=runner.query(conn, sql,id,new BeanHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;	
	}
	
	//根据id删除用户
	public void deleteUserById(Integer id){
		try {
			QueryRunner runner=new QueryRunner();
			String sql="delete from t_user where id=?";
			runner.update(JdbcUtil.getConnection(), sql,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//修改用户信息
	public void updateUser(User user){
		try {
			QueryRunner runner=new QueryRunner();
			String sql="update t_user set name=?,password=?,role=? where id=?";
			Object[] params={user.getName(),user.getPassword(),user.getRole(),user.getId()};
			runner.update(JdbcUtil.getConnection(), sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 增加用户信息
	public void addUser(User user) {
		QueryRunner runner=new QueryRunner();
		try {
			String sql="insert into t_user values (null,?,?,?)";
			Object[] params={user.getName(),user.getPassword(),user.getRole()};
			runner.update(JdbcUtil.getConnection(), sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 通过id查询用户
	public User findUsrById(Connection conn, Integer userId) {
		QueryRunner runner=new QueryRunner();
		User user=null;
		try {
			String sql="select * from t_user where id=?";
			user = runner.query(conn, sql, userId, new BeanHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	
		
}
