package com.xyy.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.xyy.enity.Shopping;
import com.xyy.enity.User;
import com.xyy.service.ShoppingService;
import com.xyy.service.imple.ShoppingServiceImple;

public class ShopAction implements ModelDriven<Shopping> {
	private Shopping shopping = new Shopping();
	private ShoppingService shoppingService = new ShoppingServiceImple();
	private String result;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public Shopping getModel() {
		return shopping;
	}
	
	// 列表展示商品信息
	public String listShopping() {
		List<Shopping> listShopping = shoppingService.listShopping();
		ActionContext.getContext().put("listShopping", listShopping);
		return "success";
	}

	// 添加商品之出现添加表单
	public String addShoppingForm() {
		return "success";
	}
	
	// 添加商品之实际添加
	public String addShopping() {
		String realPath = ServletActionContext.getServletContext().getRealPath("/image");
		try {
			FileUtils.copyFile(this.shopping.getImgs(), new File(realPath,this.shopping.getImgsFileName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		shoppingService.addShopping(this.shopping);
		return "success";
	}
	
	// 根据id删除商品
	public String deleteShopping() {
		shoppingService.deleteShopping(this.shopping.getId());
		return "success";
	}
	
	//	通过id查询商品
	public String findShoppingById() {
		Shopping shopping = shoppingService.findShoppingById(this.shopping.getId());
		ActionContext.getContext().put("updateShopping", shopping);
		return "success";
	}
	
	//	实际修改商品
	public String updateShopping() {
		if(this.shopping.getImgs()!=null){
			String realPath = ServletActionContext.getServletContext().getRealPath("/image");
			try {
				FileUtils.copyFile(this.shopping.getImgs(), new File(realPath,this.shopping.getImgsFileName()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		shoppingService.updateShopping(this.shopping);
		return "success";
	}
	
	//商品列表action到商品展示的跳转ajax
	public String listToAjax(){
		return "success";
	}
	
}
