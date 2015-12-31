package com.mmm.admin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.mmm.interceptor.AdminloginInterceptor;
/**
 * 修改密码
 * @author majinliang
 *
 */
@Before(AdminloginInterceptor.class)
public class PasswordController extends Controller{

	public void index(){

		renderFreeMarker("/admin/password.html");
	}
	
	/**
	 * 执行修改密码
	 * @throws NoSuchAlgorithmException
	 */
	public void change() throws NoSuchAlgorithmException{
		String password1 = getPara("password1");
		String password2 = getPara("password2");
		if(password1.equals(password2)){
			String sql = "update db_adminuser set password = ? where id = 1";
			Db.update(sql, MD5(password1));	
			redirect("/admin/article");		
		}else{
			redirect("/admin/password");
		}
	}
	/**
	 * MD5加密算法
	 * @param oldStr
	 * @return 加密后的字符串
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
}
