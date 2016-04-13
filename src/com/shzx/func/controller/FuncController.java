package com.shzx.func.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shzx.common.AbstractController;
import com.shzx.common.SysContants;
import com.shzx.func.entity.FuncGroup;
import com.shzx.func.entity.FuncItem;
import com.shzx.func.service.FuncGroupService;
import com.shzx.func.service.FuncItemService;
import com.shzx.role.entity.RoleFunc;
import com.shzx.role.entity.UserRole;
import com.shzx.role.service.RoleFuncService;
import com.shzx.role.service.RoleInfoService;
import com.shzx.role.service.UserRoleService;
import com.shzx.user.entity.UserInfo;

@Controller
@RequestMapping(value="/func")
public class FuncController extends AbstractController{

	private static Log logger = LogFactory.getLog(FuncController.class); 

	@Autowired
	private FuncItemService funcItemService; 
	@Autowired
	private FuncGroupService funcGroupService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private RoleInfoService roleInfoService; 
	@Autowired
	private RoleFuncService roleFuncService;
	
	@RequestMapping("/funcMain")
	public String funcMain(HttpServletRequest request){
		List<FuncGroup> funcGroups = new ArrayList<FuncGroup>();
		List<FuncItem> items = new ArrayList<FuncItem>();
		try {
			UserInfo userInfo = (UserInfo) request.getSession().getAttribute(SysContants.SESSION_USER_KEY);
			List<UserRole> userRoles = userRoleService.findListByUserId(userInfo.getId());
			if(userRoles != null){
				List<RoleFunc> roleFuncs = new ArrayList<RoleFunc>();
				for(UserRole userRole : userRoles){
					List<RoleFunc> list = roleFuncService.findListByGroupId(userRole.getRoleId());
					for(RoleFunc roleFunc : list){
						roleFuncs.add(roleFunc);
					}
				}
				Iterator<FuncGroup> it = null;
				List<String> funcIds = new ArrayList<String>();
				if(roleFuncs != null && roleFuncs.size() != 0){
					for(RoleFunc roleFunc : roleFuncs){
						List<FuncGroup> list = funcGroupService.findListByGroupId(roleFunc.getGroupId());
						if(list != null){
							for(FuncGroup funcGroup : list){
								funcGroups.add(funcGroup);
								it = funcGroups.iterator();
								while(it.hasNext()){
									FuncGroup funcGroup2 = it.next();
									if(funcIds.contains(funcGroup2.getFuncId())){
										continue;
									}else{
										funcIds.add(funcGroup.getFuncId());
									}
								}
							}
							
						}
					}
					for(String funcId : funcIds){
						FuncItem funcItem  = funcItemService.findById(funcId);
						items.add(funcItem);
					}
				}
			}
			request.setAttribute("items",items );
			request.setAttribute("groups",funcGroups);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("加载功能项失败，失败信息："+e.getMessage(),e);
		}
		return "main";
	}

}
