package com.hhdys.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.hhdys.model.Account;
import com.hhdys.model.Position;
import com.hhdys.model.Role;
import com.hhdys.service.AccountService;
import com.hhdys.service.PositionService;
import com.hhdys.service.RoleService;
import com.opensymphony.xwork2.ActionSupport;

public class AccountAction extends ActionSupport {
	@Resource(name = "as")
	private AccountService as;
	@Resource(name = "role")
	private RoleService roleService;
	@Resource(name = "position")
	private PositionService positionService;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();

	public AccountService getAs() {
		return as;
	}

	public void setAs(AccountService as) {
		this.as = as;
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

	public void getRoleList() throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		List<Role> list = roleService.getList();
		JSONArray jsonArray = new JSONArray(list);
		PrintWriter out = response.getWriter();
		out.write(jsonArray.toString());
		out.flush();
		out.close();
	}

	public void getPositionList() throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		List<Position> list = positionService.getList();
		JSONArray jsonArray = new JSONArray(list);
		PrintWriter out = response.getWriter();
		out.write(jsonArray.toString());
		out.flush();
		out.close();
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public PositionService getPositionService() {
		return positionService;
	}

	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}
}
