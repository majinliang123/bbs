package com.mmm.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
/**
 * 拦截器
 * 当用户没有登录时，不允许进入内部
 * @author majinliang
 *
 */
public class UserloginInterceptor implements Interceptor{

	public void intercept(Invocation inv) {
	
		// TODO Auto-generated method stub		
		Controller controller = inv.getController();
        String loginUser = controller.getSessionAttr("user");
		if (loginUser != null){
			inv.invoke();
		}		   
		else{
			controller.redirect("/user/login");
		}	     
	}

}
