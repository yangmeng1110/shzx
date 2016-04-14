package com.shzx.role.service;

import java.util.List;

import com.shzx.role.entity.UserRole;

public interface UserRoleService {

	public static final String BEAN_NAME = "userRoleService";
	
	public List<UserRole> findListByUserId(String userId);
}
