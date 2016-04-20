package com.shzx.func.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shzx.common.AbstractController;

@Controller
@RequestMapping(value="/funcGroup")
public class FuncGroupController extends AbstractController{

	@RequestMapping(value="/toQueryFuncGroupList")
	public String toQueryFuncGroupList(HttpServletRequest request){
		return "func/funcGroup_list";
	}
}
