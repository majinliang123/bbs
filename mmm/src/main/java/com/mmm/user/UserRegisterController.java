package com.mmm.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.mmm.validator.UserRegisterValidator;
/**
 * 用户注册
 * @author majinliang
 *
 */
public class UserRegisterController extends Controller{
	/**
	 * 打开注册页
	 */
	public void index(){
		renderFreeMarker("/user/register.html");
	}
	
	/**
	 * 进行注册
	 * @throws NoSuchAlgorithmException 
	 */
	@Before(UserRegisterValidator.class)
	public void register() throws NoSuchAlgorithmException{
		String username = getPara("username");
		String password = getPara("password1");
		String email = getPara("email");
		User user = getModel(User.class);
		user.set("username", username);		
		user.set("password", MD5(password));		
		user.set("email", email);		
		if(user.save()){
			redirect("/user/login");
		}		
	}

	/**
	 * 生成MD5
	 * 密码生成
	 * @param oldStr
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public String MD5(String oldStr) throws NoSuchAlgorithmException{

			char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
				    'a', 'b', 'c', 'd', 'e', 'f' }; 
			byte[] oldBytes = oldStr.getBytes();
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(oldBytes);
			byte[] newBytes = md.digest();
			char newStr[] = new char[32]; 
			for (int i = 0; i < 16; i++) { 
				byte tmp = newBytes[i]; 
			    newStr[2*i] = hexDigits[tmp >>> 4 & 0xf]; 
			    newStr[2*i+1] = hexDigits[tmp & 0xf]; 
			 } 
			 return new String(newStr);
		}
		public void dd(){
			System.err.println("sd");
		}
}
