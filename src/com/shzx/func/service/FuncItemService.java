package com.shzx.func.service;

import com.shzx.func.entity.FuncItem;

public interface FuncItemService {

	public static final String BEAN_NAME = "funcItemService";
	
	public FuncItem findById(String id);
}
