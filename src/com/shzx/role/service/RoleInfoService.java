package com.shzx.role.service;

import com.shzx.role.entity.RoleInfo;

public interface RoleInfoService {

	public static final String BEAN_NAME = "roleInfoService"; 
	
	public RoleInfo findRoleInfoById(String id);
}
