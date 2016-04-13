package com.shzx.func.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shzx.func.dao.FuncItemDAO;
import com.shzx.func.entity.FuncItem;
import com.shzx.func.service.FuncItemService;

@Service(FuncItemService.BEAN_NAME)
public class FuncItemServiceImpl implements FuncItemService{

	@Autowired
	private FuncItemDAO funcItemDAO;

	@Override
	public FuncItem findById(String id) {
		return funcItemDAO.findById(id.trim());
	}


}
