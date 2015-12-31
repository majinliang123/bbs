package com.mmm.admin;

import java.util.Map;

import com.jfinal.plugin.activerecord.Model;
/**
 * 管理员
 * @author majinliang
 *
 */

public class AdminUser extends Model<AdminUser>{
	
	private static final long serialVersionUID = 1L;
	public static AdminUser dao = new AdminUser();
	public Map<String,Object> getAttrs(){
		return super.getAttrs();
	}

}
