package com.shzx.role.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shzx.common.AbstractDAO;
import com.shzx.role.entity.UserRole;
@Repository
public class UserRoleDAO extends AbstractDAO{

	public List<UserRole> findListByUserId(String userId) {
		return super.findListByProperty("selectUserRoleByUserId", userId);
	}

	
}
