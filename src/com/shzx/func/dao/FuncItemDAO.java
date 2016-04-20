package com.shzx.func.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shzx.common.AbstractDAO;
import com.shzx.func.entity.FuncItem;
import com.shzx.user.entity.UserInfo;
@Repository
public class FuncItemDAO extends AbstractDAO{

	public FuncItem findById(String id) {
		return (FuncItem) findByProperty("selectFuncItemById", id);
	}

	public List<FuncItem> findByPage(Map<String,Object> map){
		return findListByProperty("selectFuncItemByPage", map);
	}
	
	public Long findCount(Map<String,Object> map){
		return super.findCount("selectFuncItemCount", map);
	}
	
	
	public int delete(String id){
		return super.deleteByProperty("deleteFuncItem", id);
	}
	
	public int update(FuncItem funcItem){
		return super.update("updateFuncItem", funcItem);
	}
	
	public int insert(FuncItem funcItem){
		return super.insert("insertFuncItem", funcItem);
	}
	
	public FuncItem findFuncItemByName(String funcName){
		return (FuncItem) super.findByProperty("selectFuncItemByName", funcName.trim());
	}
	
}
