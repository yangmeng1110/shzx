package com.shzx.role.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shzx.role.dao.RoleFuncDAO;
import com.shzx.role.entity.RoleFunc;
import com.shzx.role.service.RoleFuncService;

@Service(RoleFuncService.BEAN_NAME)
public class RoleFuncServiceImpl implements RoleFuncService {

	@Autowired
	private RoleFuncDAO roleFuncDAO;
	
	@Override
	public List<RoleFunc> findListByGroupId(String groupId) {
		return roleFuncDAO.findListByGroupId(groupId);
	}

}
