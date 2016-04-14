package com.shzx.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.shzx.common.AbstractController;
import com.shzx.common.SysContants;
import com.shzx.user.entity.UserInfo;
import com.shzx.user.service.UserInfoService;
import com.shzx.util.MD5Util;
/**
 * 登录Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/login")
public class LoginController extends AbstractController{

	private Log logger = LogFactory.getLog(LoginController.class); 
	
	@Autowired
	private UserInfoService userInfoService; 
	
	@RequestMapping(value="/forwardLogin")
	public String forwardLogin(HttpServletRequest request){
//		TokenProcessor tokenProcessor = TokenProcessor.getInstance();
//		String token = tokenProcessor.makeToken();
//		request.getSession().setAttribute(Contants.Token, token);
		return "login";
	}
	
	@ResponseBody
	@RequestMapping(value="/doLogin")
	public String doLogin(HttpSession session,HttpServletRequest request){
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String returnMsg = "";
		try {
			if(userName != null && userName.trim().length() != 0 || password != null && password.trim().length() != 0){
				UserInfo userInfo = userInfoService.findByUserName(userName);
				if(userInfo != null){
					if(!MD5Util.toMD5(password.trim()).equals(userInfo.getPassword())){
						returnMsg = SysContants.RETURN_MSG_ERROR_CODE;
					}else{
						returnMsg = SysContants.RETURN_MSG_RIGHT_CODE;
						request.getSession().setAttribute(SysContants.SESSION_USER_KEY,userInfo );
					}
				}else{
					returnMsg = SysContants.RETURN_MSG_ERROR_CODE;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("登录验证失败，失败原因:"+e.getMessage(), e);
		}
		return JSON.toJSONString(returnMsg);
	}
	
	@RequestMapping(value="/logOut")
	public String logOut(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session != null){
			session.invalidate();
		}
		return "redirect:forwardLogin";
	}
	
}
