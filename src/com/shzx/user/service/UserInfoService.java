package com.shzx.user.service;

import java.util.List;
import java.util.Map;

import com.shzx.user.entity.UserInfo;

public interface UserInfoService {

	public static final String BEAN_NAME = "userInfoService";
	
	public UserInfo findByUserName(String userName);
	
	public List<UserInfo> findByPage(Map<String,Object> map);
	
	public Long findCount(Map<String,Object> map);
	
	public int saveUserInfo(UserInfo userInfo);
	
	public int deleteUserInfoById(String id);
	
	public int updateUserInfo(UserInfo userInfo);
	
}
