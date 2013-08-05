package com.hhdys.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

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
			List<Map<String, String>> list = as.getUserList("", Integer.parseInt(pageSizeStr),
					Integer.parseInt(curPageStr));
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("rows", list);
			jsonObject.put("total", as.getTotalSize(""));
			PrintWriter out = response.getWriter();
			out.write(jsonObject.toString());
			out.flush();
			out.close();
		}
	}

	public void addAccount() throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		String name = request.getParameter("name");
		int sex = Integer.parseInt(request.getParameter("sex"));
		int age = Integer.parseInt(request.getParameter("age"));
		int position = Integer.parseInt(request.getParameter("position"));
		int role = Integer.parseInt(request.getParameter("role"));
		int department = Integer.parseInt(request.getParameter("department"));
		Account account = new Account();
		account.setAge(age);
		account.setCreateTime(System.currentTimeMillis());
		account.setDepartment(department);
		account.setInuse(0);
		account.setName(name);
		account.setPassword(passWord);
		account.setPosition(position);
		account.setRole(role);
		account.setSex(sex);
		account.setUsername(userName);
		PrintWriter out = response.getWriter();
		if (as.addUser(account)) {
			out.write("{\"success\":true,\"msg\":\"添加成功！\"}");
		} else {
			out.write("{\"success\":true,\"msg\":\"添加失败！\"}");
		}
		out.flush();
		out.close();
	}

	public void editAccount() throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		String name = request.getParameter("name");
		int sex = Integer.parseInt(request.getParameter("sex"));
		int age = Integer.parseInt(request.getParameter("age"));
		int position = Integer.parseInt(request.getParameter("position"));
		int role = Integer.parseInt(request.getParameter("role"));
		int department = Integer.parseInt(request.getParameter("department"));
		int id = Integer.parseInt(request.getParameter("id"));
		Account account = new Account();
		account.setAge(age);
		account.setCreateTime(System.currentTimeMillis());
		account.setDepartment(department);
		account.setInuse(0);
		account.setName(name);
		account.setPassword(passWord);
		account.setPosition(position);
		account.setRole(role);
		account.setSex(sex);
		account.setUsername(userName);
		account.setId(id);
		PrintWriter out = response.getWriter();
		if (as.editUser(account)) {
			out.write("{\"success\":true,\"msg\":\"修改成功！\"}");
		} else {
			out.write("{\"success\":true,\"msg\":\"修改失败！\"}");
		}
		out.flush();
		out.close();
	}

	public void checkUserName() throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		PrintWriter out = response.getWriter();
		if (as.checkUserName(userName)) {
			out.write("false");
		} else {
			out.write("true");
		}
		out.flush();
		out.close();
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
