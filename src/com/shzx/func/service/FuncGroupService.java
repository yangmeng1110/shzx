package com.shzx.func.service;

import java.util.List;

import com.shzx.func.entity.FuncGroup;

public interface FuncGroupService {

	public static final String BEAN_NAME = "funcGroupService";
	
	public List<FuncGroup> findListByGroupId(String groupId);
}
