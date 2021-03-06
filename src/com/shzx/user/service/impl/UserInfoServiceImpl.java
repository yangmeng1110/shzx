package com.shzx.user.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shzx.func.controller.FuncController;
import com.shzx.user.dao.UserInfoDAO;
import com.shzx.user.entity.UserInfo;
import com.shzx.user.service.UserInfoService;

@Service(UserInfoService.BEAN_NAME)
public class UserInfoServiceImpl implements UserInfoService {

	private static Log logger = LogFactory.getLog(UserInfoServiceImpl.class); 
	
	@Autowired
	private UserInfoDAO userInfoDAO;
	
	@Override
	public UserInfo findByUserName(String userName) {
		return userInfoDAO.findByUserName(userName);
	}

	@Override
	public List<UserInfo> findByPage(Map<String, Object> map) {
		return userInfoDAO.findByPage(map);
	}

	@Override
	public Long findCount(Map<String, Object> map) {
		return userInfoDAO.findCount(map);
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Override
	public int saveUserInfo(UserInfo userInfo) {
		return userInfoDAO.insert(userInfo);
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Override
	public int deleteUserInfoById(String id) {
		return userInfoDAO.delete(id);
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public int updateUserInfo(UserInfo userInfo) {
		return userInfoDAO.update(userInfo);
	}

}
