package com.shzx.func.service;

import java.util.List;
import java.util.Map;

import com.shzx.func.entity.FuncItem;

public interface FuncItemService {

	public static final String BEAN_NAME = "funcItemService";
	
	public FuncItem findById(String id);
	
	public List<FuncItem> findByPage(Map<String,Object> map);
	
	public Long findCount(Map<String,Object> map);
	
	public int saveFuncItem(FuncItem funcItem);
	
	public int deleteFuncItemById(String id);
	
	public int updateFuncItem(FuncItem funcItem);
	
	public FuncItem findFuncItemByName(String funcName);
	
}
