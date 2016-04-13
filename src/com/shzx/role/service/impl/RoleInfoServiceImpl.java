package com.shzx.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shzx.role.dao.RoleInfoDAO;
import com.shzx.role.entity.RoleInfo;
import com.shzx.role.service.RoleInfoService;

@Service(RoleInfoService.BEAN_NAME)
public class RoleInfoServiceImpl implements RoleInfoService {

	@Autowired
	private RoleInfoDAO roleInfoDAO;
	
	@Override
	public RoleInfo findRoleInfoById(String id) {
		return roleInfoDAO.findRoleInfoById(id);
	}

}
