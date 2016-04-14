package com.shzx.role.service;

import java.util.List;

import com.shzx.role.entity.RoleFunc;

public interface RoleFuncService {

	public static final String BEAN_NAME = "roleFuncService";
	
	public List<RoleFunc> findListByGroupId(String groupId);
}
