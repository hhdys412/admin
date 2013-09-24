package com.hhdys.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhdys.service.AccountService;
import com.hhdys.util.CookieUtil;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/admin")
@ResultPath("/")
@Service
public class LoginAction extends ActionSupport {
	@Autowired
	private AccountService as;

	@Action(results = { @Result(name = "index", location = "login!index", type = "redirectAction") })
	public String login() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (as.checkUser(userName, password)) {
			CookieUtil cookie = CookieUtil.getInstance(request, response);
			cookie.setCookie("username", userName, -1);
			cookie.setCookie("password", Base64.encodeBase64String(password.getBytes()), -1, true);
			return "index";
		}
		request.setAttribute("msg", "用户名或密码不对!");
		return "../pub/tips";
	}

	public String index() {
		return "main";
	}

	public AccountService getAs() {
		return as;
	}

	public void setAs(AccountService as) {
		this.as = as;
	}

}
