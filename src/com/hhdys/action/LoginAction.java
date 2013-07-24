package com.hhdys.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.hhdys.service.AccountService;
import com.hhdys.util.CookieUtil;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/admin")
@ResultPath("/")
public class LoginAction extends ActionSupport {
	@Resource(name = "as")
	private AccountService as;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();

	@Action(results = { @Result(name = "index", location = "login!index", type = "redirect") })
	public String login() {
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
