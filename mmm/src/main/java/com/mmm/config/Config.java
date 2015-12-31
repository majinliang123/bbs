package com.mmm.config;


import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.mmm.index.Article;
import com.mmm.index.ArticleController;
import com.mmm.index.Category;
import com.mmm.index.Discuss;
import com.mmm.index.FawenController;
import com.mmm.index.IndexController;
import com.mmm.user.User;
import com.mmm.user.UserIndexController;
import com.mmm.user.UserLoginController;
import com.mmm.user.UserRegisterController;



/**
 * 配置
 * @author majinliang
 *
 */
public class Config extends JFinalConfig{
	
	@Override
	public void configConstant(Constants me) {
		loadPropertyFile("a_little_config.txt");//设置配置文件
		me.setDevMode(getPropertyToBoolean("devMode", false));//设置为调试模式
		me.setViewType(ViewType.FREE_MARKER);//调用视图
		//ʹ上传文件的路径，用双斜杠！！！！
		//me.setUploadedFileSaveDirectory("C:\\software\\tomcat\\webapps\\uploads");
	}
	
	//配置路由
	@Override
	public void configRoute(Routes me) {
		//用户登录,注册找回密码等
		me.add("/user/login", UserLoginController.class);
		me.add("/user", UserIndexController.class);
		me.add("/user/register", UserRegisterController.class);
		//首页
		me.add("/index", IndexController.class);
		//正文页
		me.add("/article",ArticleController.class);
		//发表文章
		me.add("/edit",FawenController.class);
	}
	
	
	//配置数据库
	@Override
	public void configPlugin(Plugins me) {
			
		C3p0Plugin c3p0Plugin = new C3p0Plugin("jdbc:mysql://localhost/mmm", "root", "");
		me.add(c3p0Plugin);	
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		arp.setShowSql(true);//设置显示查询语句
		me.add(arp);		
		//配置表的映射
		arp.addMapping("db_user", User.class);//用户数据库
		arp.addMapping("db_article", Article.class);//文章数据库
		arp.addMapping("db_category", Category.class);//栏目数据库
		arp.addMapping("db_discuss", Discuss.class);//评论数据库
	}

	//配置全局拦截器
	@Override
	public void configInterceptor(Interceptors me) {		
		me.add(new SessionInViewInterceptor(true));	//使用session
	}

	
	@Override
	public void configHandler(Handlers me) {	
		me.add(new ContextPathHandler("contextPath"));		
	}
}
