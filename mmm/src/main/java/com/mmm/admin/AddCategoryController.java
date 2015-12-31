package com.mmm.admin;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.mmm.interceptor.AdminloginInterceptor;

/**
 * 添加栏目
 * @author majinliang
 *
 */
@Before(AdminloginInterceptor.class)
public class AddCategoryController extends Controller{

	public void index(){
		renderFreeMarker("/admin/addcategory.html");
	}
	
	public void add(){
		
		String cate = getPara("cate");		
		String sql = "insert into `db_category`(`cname`) values(?)";
		Db.update(sql, cate);	
		redirect("/admin/article");		
	}
}
