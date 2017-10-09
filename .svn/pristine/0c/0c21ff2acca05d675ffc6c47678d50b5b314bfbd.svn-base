package com.xyy.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.xyy.enity.User;
import com.xyy.service.UserService;

public class UserAction implements ModelDriven<User>{
	private User user=new User();
	private UserService userService=new UserService();
	
	private String searchName;
	private Integer pageIndex;
	private Integer pageSize;
	
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public String getSearchName() {
		return searchName;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	@Override
	public User getModel() {
		return user;
	}
		
//	登录表单
	public String loginForm(){
		return "success";
	}
	
//	登录验证
	public String login(){
		User loginUser = userService.loginCheck(user);
		if(loginUser!=null){
			ActionContext.getContext().put("loginUser", loginUser);
			ActionContext.getContext().getSession().put("user", loginUser);
			return "success";
		}else{
			return "error";
		}	
	}
	
//	列表展示用户信息
	public String listUser(){
		List<User> listUser = userService.listUser(searchName);
		ActionContext.getContext().put("listUser", listUser);
		ActionContext.getContext().put("searchName", searchName);
		return "success";
	}
	
//	分页展示用户信息
	public String pageUser(){
		Map<String,Object> page = userService.pageUser(pageIndex,pageSize,searchName);
		ActionContext.getContext().put("page", page);
		ActionContext.getContext().put("searchName", searchName);
		return "success";
	}
	
//	通过id删除用户
	public String deleteUserById() {
		userService.deleteUserById(this.user.getId());
		ActionContext.getContext().put("searchName", searchName);
		return "success";
	}
	
//	通过id查询用户	
	public String findUserById() {
		User user = userService.findUserById(this.user.getId());
		ActionContext.getContext().put("updateUser", user);
		ActionContext.getContext().put("searchName", searchName);
		return "success";
	}
	
//	修改用户信息	
	public String updateUser(){
		userService.updateUser(this.user);
		ActionContext.getContext().put("searchName", searchName);
		return "success";
	}
//	添加用户信息出现表单	
	public String addUserForm(){
		return "success";
	}
	
//	添加用户信息	
	public String addUser(){
		userService.addUser(this.user);
		return "success";
	}
	
}
