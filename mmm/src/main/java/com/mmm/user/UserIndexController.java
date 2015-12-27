package com.mmm.user;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.mmm.interceptor.UserloginInterceptor;
/**
 * 后台首页控制器
 * @author majinliang
 *
 */
@Before(UserloginInterceptor.class)//验证是否进行了登录
public class UserIndexController extends Controller{
	
	public void index(){	
		renderFreeMarker("/user/index.html");
	}
	
	public void loginOut(){
		removeSessionAttr("user");
		redirect("/user/login");
	}
}
