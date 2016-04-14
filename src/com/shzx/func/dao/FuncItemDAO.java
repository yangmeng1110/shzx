package com.shzx.func.dao;

import org.springframework.stereotype.Repository;

import com.shzx.common.AbstractDAO;
import com.shzx.func.entity.FuncItem;
@Repository
public class FuncItemDAO extends AbstractDAO{

	public FuncItem findById(String id) {
		return (FuncItem) findByProperty("selectFuncItemById", id);
	}

	
	
}
