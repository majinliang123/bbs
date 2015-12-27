package com.mmm.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * 用户登录校验֤
 * @author majinliang
 *
 */
public class UserLoginValidator extends Validator{

	/**
	 * 对登录信息进行校验֤
	 */
	@Override
	protected void validate(Controller c) {
		
		validateRequiredString("username", "username", "用户名不能为空");
		validateRequiredString("password", "password", "密码不能为空");
	}

	/**
	 * 验证失败时执行
	 */
	@Override
	protected void handleError(Controller c) {
		
		c.renderFreeMarker("/user/login.html");
	}

}
