package com.mmm.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * 对用户注册的信息进行验证
 * @author majinliang
 *
 */
public class UserRegisterValidator extends Validator{
	/**
	 * 对注册信息进行校验֤
	 */
	@Override
	protected void validate(Controller c) {
		
		validateRequiredString("username", "username", "用户名不能为空");
		validateRequiredString("password1", "password1", "密码不能为空");
		validateRequiredString("password2", "password2", "密码不能为空");
		validateRequiredString("email", "email", "邮箱不能为空");
		String password1 = c.getPara("password1");
		String password2 = c.getPara("password2");
		validateEqualString(password1, password2, "password2", "两次输入的密码不一致");
		validateEmail("email", "emailMsg", "电子邮箱格式错误");
	}

	/**
	 * 验证失败时执行
	 */
	@Override
	protected void handleError(Controller c) {		
		c.renderFreeMarker("/user/register.html");
	}
}
