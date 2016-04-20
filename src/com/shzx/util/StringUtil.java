package com.shzx.util;

import java.util.Random;
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
		return uuid.toString().replace("-", "");
	}
	public static void main(String[] args) {
		System.out.println(getUuid());
	}
}
