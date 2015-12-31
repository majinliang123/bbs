package com.mmm.index;

import java.util.Map;

import com.jfinal.plugin.activerecord.Model;

/**
 * 栏目
 * @author majinliang
 *
 */

public class Category extends Model<Category>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Category dao = new Category();
	public Map<String,Object> getAttrs(){
		return super.getAttrs();
	}

}
