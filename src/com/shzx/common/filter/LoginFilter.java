package com.shzx.common.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shzx.common.SysContants;
import com.shzx.user.entity.UserInfo;

/**
 * 登录拦截
 * @author Administrator
 *
 */
public class LoginFilter implements Filter{


	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(SysContants.SESSION_USER_KEY);
		String url = request.getRequestURI();
		String accept = request.getHeader("accept");
		boolean isFilter = filterUrl(url);
		if(isFilter){
			if(userInfo == null){
				if(isAjaxReq(accept)){
					responseForJSONRequest(request, response);
				}else{
					response.sendRedirect(request.getContextPath()+"/index.jsp");
				}
			}else{
				filterChain.doFilter(request, response);
			}
		}else{
			filterChain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	@Override
	public void destroy() {
		
	}
	
	/**
	 * 判断URL是否需要拦截
	 * @param url 不需要拦截的URL
	 * @return
	 */
	public boolean filterUrl(String url){
		String[] noFilterStr = new String[]{"js","css","images","forwardLogin","logOut","index","doLogin"};
		boolean isFilter = true;
		for(String str : noFilterStr){
			if(url.indexOf(str) != -1){
				isFilter = false;
				break;
			}
		}
		return isFilter;
	}
	
	/**
	 * 判断是否是Ajax请求
	 * @param accept
	 * @return
	 */
	public boolean isAjaxReq(String accept){
		if(accept.contains("json")){
			return true;
		}
		return false;
	}
	
	/**
	 * 对未登录且是ajax请求作出响应
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void responseForJSONRequest(HttpServletRequest request,HttpServletResponse response) throws IOException{
		StringBuffer script = new StringBuffer("{\"noLogin\"}");
		response.setContentType("application/json; charset=utf-8");
		response.setCharacterEncoding("UTF-8"); 
		PrintWriter out = response.getWriter();
		out.print(script.toString());
		out.flush();
		out.close();
	}
}
