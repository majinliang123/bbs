package com.mmm.admin;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.mmm.validator.AdminLoginValidator;


/**
 *后台登录控制器
 * @author majinliang
 *
 */
public class AdminLoginController extends Controller{

	/**
	 * 显示登录页
	 * @throws NoSuchAlgorithmException 
	 */
	public void index(){
		renderFreeMarker("/admin/adminlogin.html");	
	}
	
	/**
	 * 进行登录验证
	 * @throws NoSuchAlgorithmException 
	 */
	@Before(AdminLoginValidator.class)//对必填信息进行验证֤
	public void login() throws NoSuchAlgorithmException{
		
		String username = getPara("username");		
		String password = getPara("password");
		password = MD5(password);
		String sql = "select * from db_adminuser where id = 1"; 
		List<AdminUser> adminuser = AdminUser.dao.find(sql);		
		if((username.equals(adminuser.get(0).getStr("username"))) && (password.equals(adminuser.get(0).getStr("password")))){
			setSessionAttr("adminUser", username);  
			redirect("/admin/article");
		}else{
			setAttr("password", "用户名或者密码错误");
			renderFreeMarker("/admin/adminlogin.html");
		}	
	}
	
	/**
	 * 退出登录
	 */
	public void loginOut(){
		removeSessionAttr("adminUser");
		redirect("/admin/login");
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
