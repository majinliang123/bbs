package com.mmm.index;

import java.util.Date;
import java.util.List;
import com.jfinal.core.Controller;
import com.mmm.user.User;
/**
 * 发布文章
 * @author majinliang
 *
 */
public class FawenController extends Controller{

	/**
	 * 显示发布文章页
	 */
	public void index(){
		String loginUser = getSessionAttr("user");
		if (loginUser != null){
			String user = getSessionAttr("user");
			setAttr("user", user);
			setAttr("logout", "注销");
			setAttr("fawen", "发布话题");
		}else{
			setAttr("user", "guist");
			setAttr("login", "登录");
		}
		String sql = "select * from db_category";
		List<Category> category = Category.dao.find(sql);
		setAttr("category", category);
		renderFreeMarker("/index/edit.html");
	}
	
	/**
	 * 发布文章操作
	 */
	public void submit(){
		Article art = getModel(Article.class);
		String title = getPara("title");
		String content = getPara("content");
		Date time = new Date();
		String username = getSessionAttr("user");
		String sql = "select * from db_user where username=?";
		User user = User.dao.findFirst(sql, username);	
		Long id = user.getLong("id");
		Long select = getParaToLong("select");
		
		art.set("content", content);	
		art.set("time", time);	
		art.set("title", title);	
		art.set("id", id);	
		art.set("cid",select);
		
		if(art.save()){
			redirect("/index");
		}							
	}
	
	
}
