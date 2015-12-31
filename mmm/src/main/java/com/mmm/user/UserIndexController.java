package com.mmm.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.mmm.interceptor.UserloginInterceptor;
import com.mmm.validator.EmailValidator;
import com.mmm.validator.PasswordValidator;
/**
 * 后台首页控制器
 * @author majinliang
 *
 */

public class UserIndexController extends Controller{
	static String random="";
	static String email="";
	/**
	 * 打开登录完成后的首页
	 */
	@Before(UserloginInterceptor.class)//验证是否进行了登录
	public void index(){	
		redirect("/index/");
	}
	
	/**
	 * 退出登录
	 */
	@Before(UserloginInterceptor.class)//验证是否进行了登录
	public void loginOut(){
		removeSessionAttr("user");
		redirect("/user/login");
	}
	
	/**
	 * 忘记密码,显示发送邮件的页面
	 */
	public void forget(){
		renderFreeMarker("/user/forget.html");
	}
	
	/**
	 * 更改密码,打开更改密码的界面
	 */
	public void changepw(){
		renderFreeMarker("/user/changepw.html");
	}
	
	/**
	 * 验证密码一致后跳转，并执行将新密码送入数据库
	 * @throws NoSuchAlgorithmException 
	 */
	@Before(PasswordValidator.class)
	public void changepwdo() throws NoSuchAlgorithmException{
		String yanzhengma =  getPara("yanzhengma");
		String password = getPara("password1");
		if(yanzhengma.equals(random)){
			Db.update("update db_user set password = ?", MD5(password));
			redirect("/user/login");
						
		}else{
			setAttr("pwdiff", "验证码错误");
			renderFreeMarker("/user/changepw.html");
		}
		
	}
	
	/**
	 * 发送邮件
	 * @throws Exception 
	 */
	@Before(EmailValidator.class)
	public void sendMail() throws Exception{
		//获取邮箱
		email = getPara("email");
		Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.163.com");
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        //使用JavaMail发送邮件的5个步骤
        //1、创建session
        Session session = Session.getInstance(prop);
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        //2、通过session得到transport对象
        Transport ts = session.getTransport();
        //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
        ts.connect("smtp.163.com", "18233698150", "1000121143");
        //4、创建邮件
        Message message = createSimpleMail(session,email);
        //5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
        redirect("/user/changepw");
	}
	
	/**
	 * 具体写一个邮件
	 * @throws Exception 
	 */
	 public static MimeMessage createSimpleMail(Session session, String email)
	            throws Exception {
		    //获取6位验证码
		     random=getSix();
	        //创建邮件对象
	        MimeMessage message = new MimeMessage(session);
	        //指明邮件的发件人
	        message.setFrom(new InternetAddress("18233698150@163.com"));
	        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
	        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
	        //邮件的标题
	        message.setSubject("忘记密码---验证码");
	        //邮件的文本内容
	        message.setContent("您好，您的验证码是："+random+"。如果不是您本人忘记密码，请忽略本邮件，由此给您带来的不便请谅解", "text/html;charset=UTF-8");
	        //返回创建好的邮件对象
	        return message;
	    }
	 
	    /**
		 * 产生随机的六位数
		 * @return
		 */
		public static String getSix(){
			Random rad=new Random();			
			String result  = rad.nextInt(1000000) +"";			
			if(result.length()!=6){
				return getSix();
			}
			return result;
		}
		
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
