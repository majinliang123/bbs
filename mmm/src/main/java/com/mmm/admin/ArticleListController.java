package com.mmm.admin;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.mmm.index.Article;
import com.mmm.interceptor.AdminloginInterceptor;
/**
 * 后台登录后的首页，也是文章列表页
 * @author majinliang
 *
 */
@Before(AdminloginInterceptor.class)
public class ArticleListController extends Controller{

	public void index(){
		String sql = "select * from db_article ";
		List<Article> article = Article.dao.find(sql);
		setAttr("article", article);
		renderFreeMarker("/admin/articlelist.html");
	}
	
	/**
	 * 删除文章
	 */
	public void del(){
		int aid = getParaToInt(0,1);
		Db.update("delete from db_article where aid = ?", aid);
		redirect("/admin/article");		
	}
}
