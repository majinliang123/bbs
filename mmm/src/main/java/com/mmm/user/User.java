package com.mmm.user;

import java.util.Map;

import com.jfinal.plugin.activerecord.Model;
/**
 * user模型
 * @author majinliang
 *
 */
public class User extends Model<User>{

	private static final long serialVersionUID = 1L;
	public static User dao = new User();
	public Map<String,Object> getAttrs(){
		return super.getAttrs();
	}

}
