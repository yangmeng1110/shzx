package com.shzx.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shzx.common.SysContants;
import com.shzx.util.StringUtil;
/**
 * 验证重复提交
 * @author Administrator
 *
 */
public class RepeatSubmitFilter implements Filter{

	private String token = StringUtil.getUuid();
	
	@Override
	public void destroy() {
		token = null;
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		request.setAttribute(SysContants.Token, token);
		arg2.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}

}
