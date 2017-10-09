package com.xyy.test;

import java.util.Random;



import org.junit.Test;

import com.xyy.enity.User;
import com.xyy.service.UserService;

public class Test1 {
	private UserService userService=new UserService();
	@Test
	public void TestFindUserById(){
		Integer id=3;
		User user = userService.findUserById(id);
		System.out.println(user);
	}
	@Test
	public void TestupdateUser(){
		User user=new User(6, "吕布", "lvbu", "很厉害");
		userService.updateUser(user);
	}
	
	@Test
	public void addUser(){
		String[] name={"武松","关羽","吕布","岳飞","袁崇焕","秦琼"};
		String[] password={"abc","369","wer","159","zyz"};
		String[] role={"挺厉害","很厉害","一般般"};
		Random random = new Random();
		for (int i = 0; i <100; i++) {
			User user=new User(null,name[random.nextInt(6)],password[random.nextInt(5)],role[random.nextInt(3)]);
			userService.addUser(user);
		}	
	}
}
