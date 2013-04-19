package com.hhdys.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.hhdys.service.AccountService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/admin")
@ResultPath("/")
public class LoginAction extends ActionSupport {
	@Resource(name="as")
	private AccountService as;

	public String login() {
		as.addUser();
		System.out.println("aaaaaa");
		return "main";
	}
	public AccountService getAs() {
		return as;
	}
	public void setAs(AccountService as) {
		this.as = as;
	}

}
