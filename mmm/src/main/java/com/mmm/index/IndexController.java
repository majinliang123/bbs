package com.mmm.index;

import java.util.List;
import com.jfinal.core.Controller;

/**
 * 首页控制器
 * @author majinliang
 *
 */
public class IndexController extends Controller{

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
		int cid = getParaToInt(0, 1);//获取第0个参数，如果没有，则为1
		sql = "select * from db_article where cid = ?";
		List<Article> article = Article.dao.find(sql,cid);
		setAttr("article", article);
		renderFreeMarker("/index/index.html");
	}
}
