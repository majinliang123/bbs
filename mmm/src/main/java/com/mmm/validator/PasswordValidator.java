package com.mmm.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * 验证用户填写的两个密码是否一致
 * @author majinliang
 *
 */
public class PasswordValidator extends Validator{

	/**
	 * 验证用户填写的两个密码是否一致֤
	 */
	@Override
	protected void validate(Controller c) {	
		String password1 = c.getPara("password1");
		String password2 = c.getPara("password2");
		validateEqualString(password1, password2, "pwdiff", "两次输入的密码不一致");
	}

	/**
	 * 验证失败时执行
	 */
	@Override
	protected void handleError(Controller c) {		
		c.renderFreeMarker("/user/changepw.html");
	}

}
