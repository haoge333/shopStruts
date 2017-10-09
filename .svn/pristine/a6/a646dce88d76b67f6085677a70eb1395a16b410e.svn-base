package com.xyy.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.xyy.dao.UserDao;
import com.xyy.enity.User;
import com.xyy.util.JdbcUtil;

public class UserService {
	private UserDao userDao=new UserDao();
	private Connection conn=JdbcUtil.getConnection();
	// 登录查询
	public User loginCheck(User user) {
		return userDao.loginCheck(user);
	}

	// 列表展示信息
	public List<User> listUser(String searchName) {
		return userDao.listUser(searchName);
	}
	
	// 分页展示信息
	public Map<String, Object> pageUser(Integer pageIndex, Integer pageSize, String searchName) {
		if(pageIndex==null){
			pageIndex=1;
		}
		if(pageSize==null){
			pageSize=10;
		}
		return userDao.pageUser(pageIndex,pageSize,searchName);
	}
	// 根据id查询用户
	public User findUserById(Integer id) {
		return userDao.findUserById(conn,id);
	}

	// 根据id删除用户
	public void deleteUserById(Integer id) {
		userDao.deleteUserById(id);
	}

	// 修改用户信息
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	
	// 增加用户信息
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	// 增加用户信息
	public void pageUser(User user) {
		userDao.addUser(user);
	}



}
