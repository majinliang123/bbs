package com.mmm.index;

import java.util.Date;
import java.util.List;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.mmm.interceptor.UserloginInterceptor;
import com.mmm.user.User;
/**
 * 文章控制器
 * @author majinliang
 *
 */
public class ArticleController extends Controller{
	static int aidfirst=1;
   /**
    * 显示文章页
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
		int aid = getParaToInt(0, aidfirst);
		aidfirst = aid;
		sql = "select * from db_article where aid = ?";
		Article article = Article.dao.findFirst(sql, aid);
		setAttr("article", article);		
		Long id = article.getLong("id");
		sql = "select username from db_user where id = ? ";
		User username =  User.dao.findFirst(sql, id);
		setAttr("edituser", username);
		sql = "select * from db_discuss where aid = ?";
		List<Discuss> discuss = Discuss.dao.find(sql, aid);
		setAttr("discuss", discuss);	
		renderFreeMarker("/index/view.html");		
	}
	/**
	 * 发表评论，并输入数据库
	 */
	@Before(UserloginInterceptor.class)
	public void discuss(){
		Discuss dis = getModel(Discuss.class);
		String text = getPara("discuss");
		Date now = new Date();
		int aid = getParaToInt(0, 1);
		String username = getSessionAttr("user");
		String sql = "select * from db_user where username=?";
		User user = User.dao.findFirst(sql, username);	
		Long id = user.getLong("id");
		dis.set("content", text);	
		dis.set("time", now);	
		dis.set("aid", aid);	
		dis.set("id", id);	
		if(dis.save()){
			redirect("/article/");
		}				
	}
}
