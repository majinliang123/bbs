package com.mmm.index;

import java.util.Map;
import com.jfinal.plugin.activerecord.Model;
/**
 * 文章
 * @author majinliang
 *
 */
public class Article extends Model<Article>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Article dao = new Article();
	public Map<String,Object> getAttrs(){
		return super.getAttrs();
	}

}
