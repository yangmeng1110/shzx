package com.shzx.user.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shzx.common.AbstractDAO;
import com.shzx.user.entity.UserInfo;

@Repository
public class UserInfoDAO extends AbstractDAO{

	public UserInfo findByUserName(String userName) {
		return (UserInfo) findByProperty("selectByUname", userName.trim());
	}


	public int insert(UserInfo userInfo) {
		return super.insert("insertUserInfo", userInfo);
	}
	
	public List<UserInfo> findByPage(Map<String,Object> map){
		return super.findListByProperty("selectUserInfoByPage", map);
	}
	
	
	public Long findCount(Map<String,Object> map){
		return super.findCount("selectUserInfoCount", map);
	}
	
	
	public int delete(String id){
		return super.deleteByProperty("deleteUserInfoById", id);
	}
	
	public int update(UserInfo userInfo){
		return super.update("updateUserInfo", userInfo);
	}
	
}
