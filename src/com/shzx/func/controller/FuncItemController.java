package com.shzx.func.controller;

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
import com.shzx.func.entity.FuncGroup;
import com.shzx.func.entity.FuncItem;
import com.shzx.func.service.FuncGroupService;
import com.shzx.func.service.FuncItemService;
import com.shzx.util.StringUtil;
/**
 * 功能项Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/funcItem")
public class FuncItemController extends AbstractController{
	
	public static final Log logger = LogFactory.getLog(FuncItemController.class);
	
	@Autowired
	private FuncItemService  funcItemService;
	@Autowired
	private FuncGroupService  funcGroupService;
	
	@RequestMapping(value="/toQueryFuncItemList")
	public String toQueryFuncItemList(){
		return "func/funcItem_list";
	}
	
	@ResponseBody
	@RequestMapping(value="/queryFuncItemList",produces={"application/json;charset=UTF-8"})
	public String queryFuncItemList(HttpServletRequest request){
		List<FuncItem> list = new ArrayList<FuncItem>();
		Long totalCount = null;
		try {
			totalCount = funcItemService.findCount(parseReqToSearchCondition(null, request));
			list = funcItemService.findByPage(parseReqToSearchCondition(null, request));
		} catch (Exception e) {
			logger.error("查询功能项列表失败，失败信息："+e.getMessage());
		}
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.put("total", totalCount);
		resultMap.put("rows",list);
		return JSON.toJSONString(resultMap);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/validateFuncGroup",produces={"application/json;charset=UTF-8"})
	public String validateFuncGroup(HttpServletRequest request,String id){
		String code = null;	
		try {
				if(id != null && id.trim().length() != 0){
					List<FuncGroup> list = funcGroupService.findListByFuncId(id);
					if(list != null && list.size() != 0){
						code = SysContants.RETURN_MSG_FAIL_CODE;
					}else{
						code = SysContants.RETURN_MSG_RIGHT_CODE;
					}
				}	
			} catch (Exception e) {
				logger.error("查询功能组失败，失败信息："+e.getMessage(),e);
				code = SysContants.RETURN_MSG_ERROR_CODE;
			}
		return JSON.toJSONString(code);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteFuncItem",produces={"application/json;charset=UTF-8"})
	public String deleteFuncItem(HttpServletRequest request,String id){
		String code = null;	
		try {
				if(id != null && id.trim().length() != 0){
					funcItemService.deleteFuncItemById(id);
					code = SysContants.RETURN_MSG_RIGHT_CODE;
				}
			} catch (Exception e) {
				logger.error("删除功能项失败，失败信息："+e.getMessage(),e);
				code = SysContants.RETURN_MSG_ERROR_CODE;
			}
		return JSON.toJSONString(code);
	}
	
	
	@RequestMapping("/toUpdateFuncItem")
	public String toUpdateFuncItem(HttpServletRequest request,String id){
		FuncItem funcItem = null;
		try {
			if(id != null && id.trim().length() != 0){
				funcItem = funcItemService.findById(id); 
			}
			request.setAttribute(SysContants.REQUEST_RESULT_OBJECT, funcItem);
		} catch (Exception e) {
			logger.error("跳转到功能项修改页面失败，失败信息："+e.getMessage(),e);
		}
		 return "func/funcItem_update";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/updateFuncItem",produces={"application/json;charset=UTF-8"})
	public String updateFuncItem(HttpServletRequest request,FuncItem funcItem){
		String code = null;
		try {
			if(funcItem != null){
				funcItemService.updateFuncItem(funcItem);
				code = SysContants.RETURN_MSG_RIGHT_CODE;
			}
		} catch (Exception e) {
			code = SysContants.RETURN_MSG_ERROR_CODE;
			logger.error("修改功能项失败，失败信息："+e.getMessage(),e);
		}
		return JSON.toJSONString(code);
	}
	
	@RequestMapping("/toAddFuncItem")
	public String toAddFuncItem(HttpServletRequest request){
		 return "func/funcItem_add";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/addFuncItem",produces={"application/json;charset=UTF-8"})
	public String addFuncItem(HttpServletRequest request,FuncItem funcItem){
		String code = null;
		try {
			funcItem.setId(StringUtil.getUuid());
			funcItemService.saveFuncItem(funcItem);
			code = SysContants.RETURN_MSG_RIGHT_CODE;
		} catch (Exception e) {
			code = SysContants.RETURN_MSG_ERROR_CODE;
			logger.error("新增功能项失败，失败信息："+e.getMessage(),e);
		}
		return JSON.toJSONString(code);
	}
	
	@ResponseBody
	@RequestMapping(value="/validateFuncName",produces={"application/json;charset=UTF-8"})
	public String validateFuncName(HttpServletRequest request,String funcName){
		boolean flag = false;
		try {
			FuncItem funcItem = funcItemService.findFuncItemByName(funcName);
			if(funcItem != null){
				flag = false;
			}else{
				flag = true;
			}
		} catch (Exception e) {
			flag = false;
			logger.error("查询功能项失败，失败信息："+e.getMessage(),e);
		}
		return JSON.toJSONString(flag);
	}
	
}
