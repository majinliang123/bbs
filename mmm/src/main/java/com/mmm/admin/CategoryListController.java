package com.mmm.admin;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.mmm.index.Category;
import com.mmm.interceptor.AdminloginInterceptor;
/**
 * 栏目列表
 * @author majinliang
 *
 */
@Before(AdminloginInterceptor.class)
public class CategoryListController extends Controller{

	public void index(){
		String sql = "select * from db_category ";
		List<Category> category = Category.dao.find(sql);
		setAttr("category", category);
		renderFreeMarker("/admin/categorylist.html");
	}
	
	public void del(){
		int cid = getParaToInt(0,1);
		Db.update("delete from db_category where cid = ?", cid);
		redirect("/admin/categorylist");		
	}
}
