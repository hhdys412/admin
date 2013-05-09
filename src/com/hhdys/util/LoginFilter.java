package com.hhdys.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {
	private FilterConfig config;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException,
			ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) arg0;
		HttpServletResponse httpResponse = (HttpServletResponse) arg1;
		CookieUtil cookie = CookieUtil.getInstance(httpRequest, httpResponse);
		String path = httpRequest.getRequestURI();
		if (path.endsWith("js") || path.endsWith("css")) {
			arg2.doFilter(arg0, arg1);
			return;
		}
		if (path.indexOf("loginAdmin") < 0 && path.indexOf("login!login") < 0 && path.indexOf("loginout") < 0) {
			if (cookie.getCookie("username") == null || cookie.getCookie("password") == null) {
				httpResponse.sendRedirect("loginout.jsp");
				return;
			}
		}
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		config = arg0;
	}

}
