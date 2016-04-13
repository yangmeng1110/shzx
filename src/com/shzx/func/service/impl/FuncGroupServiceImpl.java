package com.shzx.func.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shzx.func.dao.FuncGroupDAO;
import com.shzx.func.entity.FuncGroup;
import com.shzx.func.service.FuncGroupService;

@Service(FuncGroupService.BEAN_NAME)
public class FuncGroupServiceImpl implements FuncGroupService {

	@Autowired
	private FuncGroupDAO funcGroupDAO; 
	
	@Override
	public List<FuncGroup> findListByGroupId(String groupId) {
		return funcGroupDAO.findListByGroupId(groupId);
	}

}
