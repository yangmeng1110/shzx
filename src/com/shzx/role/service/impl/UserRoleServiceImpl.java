package com.shzx.role.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shzx.role.dao.UserRoleDAO;
import com.shzx.role.entity.UserRole;
import com.shzx.role.service.UserRoleService;

@Service(UserRoleService.BEAN_NAME)
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleDAO userRoleDAO;
	
	@Override
	public List<UserRole> findListByUserId(String userId) {
		return userRoleDAO.findListByUserId(userId);
	}

}
