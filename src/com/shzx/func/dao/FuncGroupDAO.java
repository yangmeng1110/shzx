package com.shzx.func.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shzx.common.AbstractDAO;
import com.shzx.func.entity.FuncGroup;

@Repository
public class FuncGroupDAO extends AbstractDAO{

	public List<FuncGroup> findListByGroupId(String groupId) {
		return findListByProperty("selectFuncGroupById", groupId.trim());
	}

	public List<FuncGroup> findListByFuncId(String funcId) {
		return findListByProperty("selectFuncGroupByFuncId", funcId.trim());
	}
}
