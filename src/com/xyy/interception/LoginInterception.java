package com.xyy.interception;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.xyy.enity.User;

public class LoginInterception extends AbstractInterceptor{
	private static final long serialVersionUID = 2164564135464L;

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		//验证登录的拦截器
		User loginUser=(User) ActionContext.getContext().getSession().get("user");
//		if(loginUser==null){
//			return "pleaseLogin";
//		}
		return actionInvocation.invoke();
	}

}
