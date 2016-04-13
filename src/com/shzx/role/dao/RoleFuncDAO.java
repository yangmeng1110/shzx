package com.shzx.role.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shzx.common.AbstractDAO;
import com.shzx.role.entity.RoleFunc;

@Repository
public class RoleFuncDAO extends AbstractDAO{

	public List<RoleFunc> findListByGroupId(String groupId){
		return findListByProperty("selectRoleFuncById", groupId);
	}
}
