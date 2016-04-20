package com.shzx.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AbstractController {

	/** 使用匿名内部类动态获取类名 */
	public static final Log logger = LogFactory.getLog(new Object() {
		public String getClassName() {
			String className = this.getClass().getName();
			return className;
		}
	}.getClassName());

	/**
	 * 判断客户端提交上来的令牌和服务器端生成的令牌是否一致
	 * 
	 * @param request
	 * @return true 用户重复提交了表单 false 用户没有重复提交表单
	 */
	protected boolean isRepeatSubmit(HttpServletRequest request) {
		String client_token = request.getParameter(SysContants.Token);
		// 1、如果用户提交的表单数据中没有token，则用户是重复提交了表单
		if (client_token == null) {
			return true;
		}
		// 取出存储在Session中的token
		String server_token = (String) request.getSession().getAttribute(SysContants.Token);
		// 2、如果当前用户的Session中不存在Token(令牌)，则用户是重复提交了表单
		if (server_token == null) {
			return true;
		}
		// 3、存储在Session中的Token(令牌)与表单提交的Token(令牌)不同，则用户是重复提交了表单
		if (!client_token.equals(server_token)) {
			return true;
		}

		return false;
	}
	
	/**
	 * 分页查询条件
	 * @param fields
	 * @param req
	 * @return
	 */
	public static Map<String, Object> parseReqToSearchCondition(
			String[] fields, HttpServletRequest req) {
		Map<String, Object> searchCdtns = new HashMap<String, Object>();
		if (null != fields) {
			for (String str : fields) {
				searchCdtns.put(str, req.getParameter(str));
			}
		}
		String page = req.getParameter("page");
		String pageSize = req.getParameter("rows");
		searchCdtns.put("page", ((Integer.parseInt(page)-1)*Integer.parseInt(pageSize)));
		searchCdtns.put("pageSize", Integer.parseInt(pageSize));
		return searchCdtns;
	}
	
	/**
	 * 获取总页数
	 * @param request
	 * @param totalCount
	 * @return
	 */
	public Long getTotalPage(HttpServletRequest request,long totalCount){
		String pageSize = request.getParameter("pageSize");
		long totalPage = 0;
		if(totalCount != 0 && Integer.parseInt(pageSize) != 0){
			totalPage = totalCount/Integer.parseInt(pageSize)+1;
		}
		return totalPage;
	}
	
	/**
	 * 显示的页码数量
	 * @param request
	 * @param totalCount
	 * @return
	 */
	public int getPageNumberShow(HttpServletRequest request,long totalCount){
		long totalPage = getTotalPage(request, totalCount);
		int pageNumberShow = 0;
		if(totalPage > 0 && totalPage <= 10){
			pageNumberShow = (int) totalPage;
		}else{
			pageNumberShow = 10;
		}
		return pageNumberShow;
	}
	
	public static void main(String[] args) {
		System.out.println(23/10+1);
	}
}
