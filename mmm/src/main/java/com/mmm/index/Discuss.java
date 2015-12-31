package com.mmm.index;

import java.util.Map;
import com.jfinal.plugin.activerecord.Model;

/**
 * 评论
 * @author majinliang
 *
 */
public class Discuss extends Model<Discuss>{

	private static final long serialVersionUID = 1L;
	public static Discuss dao = new Discuss();
	public Map<String,Object> getAttrs(){
		return super.getAttrs();
	}

}
