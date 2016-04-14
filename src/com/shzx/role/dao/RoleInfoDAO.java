package com.shzx.role.dao;

import org.springframework.stereotype.Repository;

import com.shzx.common.AbstractDAO;
import com.shzx.role.entity.RoleInfo;

@Repository
public class RoleInfoDAO extends AbstractDAO{

	public RoleInfo findRoleInfoById(String id) {
		return (RoleInfo) super.findByProperty("selectRoleInfoById", id);
	}
	
}
