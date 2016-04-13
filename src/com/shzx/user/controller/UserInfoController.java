package com.shzx.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.shzx.common.AbstractController;
import com.shzx.common.SysContants;
import com.shzx.func.controller.FuncController;
import com.shzx.user.entity.UserInfo;
import com.shzx.user.service.UserInfoService;
import com.shzx.util.MD5Util;
import com.shzx.util.StringUtil;

@Controller
@RequestMapping("/user")
public class UserInfoController extends AbstractController{
	
	private static Log logger = LogFactory.getLog(FuncController.class); 
	
	@Autowired
	private UserInfoService userInfoService;

	
	@RequestMapping("/toQueryUserInfoList")
	public String toQueryUserInfoList(){
		return "user/user_list";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/queryUserList",produces={"application/json;charset=UTF-8"})
	public String queryUserInfoList(HttpServletRequest request){
		List<UserInfo> list = new ArrayList<UserInfo>();
		Long totalCount = null;
		String[] searchParams = new String[]{"userName","realName"};
		try {
			totalCount = userInfoService.findCount(parseReqToSearchCondition(searchParams, request));
			list = userInfoService.findByPage(parseReqToSearchCondition(searchParams, request));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String,Object> resultMap = new HashMap<String, Object>();
//		resultMap.put(SysContants.REQUEST_RESULT_LIST, list);
//		resultMap.put(SysContants.REQUEST_PAGE_COUNT, getTotalPage(request, totalCount));
//		resultMap.put(SysContants.REQUEST_PAGE_NUMBER, getPageNumberShow(request, totalCount));
		resultMap.put("total", totalCount);
		resultMap.put("rows",list);
		return JSON.toJSONString(resultMap);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/deleteUserInfo",produces={"application/json;charset=UTF-8"})
	public String deleteUserInfo(HttpServletRequest request,String id){
		String code = null;	
		try {
				if(id != null && id.trim().length() != 0){
					userInfoService.deleteUserInfoById(id);
					code = SysContants.RETURN_MSG_RIGHT_CODE;
				}
			} catch (Exception e) {
				logger.error("删除用户失败，失败信息："+e.getMessage(),e);
				code = SysContants.RETURN_MSG_ERROR_CODE;
			}
		return JSON.toJSONString(code);
	}
	
	
	@RequestMapping("/toUpdateUserInfo")
	public String toUpdateUserInfo(HttpServletRequest request,String userName){
		UserInfo userInfo = null;
		try {
			if(userName != null && userName.trim().length() != 0){
				userInfo = userInfoService.findByUserName(userName); 
			}
			request.setAttribute(SysContants.REQUEST_RESULT_OBJECT, userInfo);
		} catch (Exception e) {
			logger.error("跳转到用户修改页面失败，失败信息："+e.getMessage(),e);
		}
		 return "user/user_update";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/updateUserInfo",produces={"application/json;charset=UTF-8"})
	public String updateUserInfo(HttpServletRequest request,UserInfo userInfo){
		String code = null;
		try {
			if(userInfo != null){
				userInfoService.updateUserInfo(userInfo);
				code = SysContants.RETURN_MSG_RIGHT_CODE;
			}
		} catch (Exception e) {
			code = SysContants.RETURN_MSG_ERROR_CODE;
			logger.error("修改用户失败，失败信息："+e.getMessage(),e);
		}
		return JSON.toJSONString(code);
	}
	
	@RequestMapping("/toAddUserInfo")
	public String toAddUserInfo(HttpServletRequest request,String userName){
		 return "user/user_add";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/addUserInfo",produces={"application/json;charset=UTF-8"})
	public String addUserInfo(HttpServletRequest request,UserInfo userInfo){
		String code = null;
		try {
			userInfo.setId(StringUtil.getUuid());
			userInfo.setPassword(MD5Util.toMD5("123456"));
			userInfoService.saveUserInfo(userInfo);
			code = SysContants.RETURN_MSG_RIGHT_CODE;
		} catch (Exception e) {
			code = SysContants.RETURN_MSG_ERROR_CODE;
			logger.error("新增用户失败，失败信息："+e.getMessage(),e);
		}
		return JSON.toJSONString(code);
	}
	
	@ResponseBody
	@RequestMapping(value="/validateUserName",produces={"application/json;charset=UTF-8"})
	public String validateUserName(HttpServletRequest request,String userName){
		boolean flag = false;
		try {
			UserInfo userInfo = userInfoService.findByUserName(userName);
			if(userInfo != null){
				flag = true;
			}else{
				flag = false;
			}
		} catch (Exception e) {
			flag = false;
			logger.error("新增用户失败，失败信息："+e.getMessage(),e);
		}
		return JSON.toJSONString(flag);
	}
	
	
}
