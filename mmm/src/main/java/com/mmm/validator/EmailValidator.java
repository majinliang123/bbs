package com.mmm.validator;

import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import com.mmm.user.User;

public class EmailValidator extends Validator{

	/**
	 * 验证用户输入的是否为邮箱֤
	 */
	@Override
	protected void validate(Controller c) {	
		validateEmail("email", "emailMsg", "电子邮箱格式错误");
		String email = c.getPara("email");
		String sql = "select * from db_user where email=?";
		List<User> userInfo = User.dao.find(sql, email);
		if(userInfo.isEmpty()){
			addError("emailMsg", "这个邮箱没有注册");
		}
		
	}

	/**
	 * 验证失败时执行
	 */
	@Override
	protected void handleError(Controller c) {		
		c.renderFreeMarker("/user/forget.html");
	}


}
