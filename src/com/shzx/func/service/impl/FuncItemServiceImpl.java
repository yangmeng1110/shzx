package com.shzx.func.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public List<FuncItem> findByPage(Map<String, Object> map) {
		return funcItemDAO.findByPage(map);
	}

	@Override
	public Long findCount(Map<String, Object> map) {
		return funcItemDAO.findCount(map);
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public int saveFuncItem(FuncItem funcItem) {
		return funcItemDAO.insert(funcItem);
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public int deleteFuncItemById(String id) {
		return funcItemDAO.delete(id);
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public int updateFuncItem(FuncItem funcItem) {
		return funcItemDAO.update(funcItem);
	}

	@Override
	public FuncItem findFuncItemByName(String funcName) {
		return funcItemDAO.findFuncItemByName(funcName);
	}


}
