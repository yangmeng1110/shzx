package com.shzx.util;

import java.util.UUID;

/**
 * 工具类
 * @author Administrator
 *
 */
public class StringUtil {

	
	/**
	 * @获取uuid
	 */
	public static String getUuid(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
}
