package com.hhdys.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.json.JSONObject;

import com.hhdys.model.Account;
import com.hhdys.service.AccountService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/admin")
@ResultPath("/")
public class LoginAction extends ActionSupport {
	@Resource(name = "as")
	private AccountService as;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();

	@Action(results = { @Result(name = "index",location="login!index", type = "redirect") })
	public String login() {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (as.checkUser(userName, password)) {
			Cookie cookie = new Cookie("username", userName);
			response.addCookie(cookie);
			return "index";
		}
		request.setAttribute("msg", "用户名或密码不对!");
		return "../pub/tips";
	}

	public String index() {
		Cookie[] cookie = request.getCookies();
		if (cookie != null) {
			for (Cookie c : cookie) {
				if (c.getName().equals("username") && c.getValue() != null) {
					return "main";
				}
			}
		}
		return "loginout";
	}

	public void showList() throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String pageSizeStr = request.getParameter("rows");
		String curPageStr = request.getParameter("page");
		if (pageSizeStr != null && curPageStr != null) {
			List<Account> list = as.getUserList("", Integer.parseInt(pageSizeStr), Integer.parseInt(curPageStr));
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("rows", list);
			jsonObject.put("total", as.getTotalSize(""));
			PrintWriter out = response.getWriter();
			out.write(jsonObject.toString());
			out.flush();
			out.close();
		}
	}

	public void delAccount() throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String ids = request.getParameter("id");
		PrintWriter out = response.getWriter();
		if (as.delAccount(ids)) {
			out.write("{\"success\":true,\"msg\":\"删除成功！\"}");
		}
		out.flush();
		out.close();
	}

	public AccountService getAs() {
		return as;
	}

	public void setAs(AccountService as) {
		this.as = as;
	}

}
