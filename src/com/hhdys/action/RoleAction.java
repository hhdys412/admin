package com.hhdys.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhdys.model.Role;
import com.hhdys.service.RoleService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/admin")
@ResultPath("/")
@Service
public class RoleAction extends ActionSupport {
	@Autowired
	private RoleService service;
	

	public void getList() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		List<Role> list = service.getList();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("rows", list);
		PrintWriter out = response.getWriter();
		out.write(jsonObject.toString());
		out.flush();
		out.close();
	}

	public void delRole() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String ids = request.getParameter("id");
		PrintWriter out = response.getWriter();
		service.delRoleById(ids);
		out.write("{\"success\":true,\"msg\":\"删除成功！\"}");
		out.flush();
		out.close();
	}

	public void updateRole() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = StringUtils.defaultString(request.getParameter("id"), "");
		String name = StringUtils.defaultString(request.getParameter("name"), "");
		PrintWriter out = response.getWriter();
		if (!id.equals("") && !name.equals("")) {
			Role r = new Role();
			r.setId(Integer.parseInt(id));
			r.setName(name);
			service.UpdateRole(r);
			out.write("{\"success\":true,\"msg\":\"修改成功！\"}");
		} else {
			out.write("{\"success\":true,\"msg\":\"操作失败！\"}");
		}
		out.flush();
		out.close();
	}

	public void addRole() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = StringUtils.defaultString(request.getParameter("name"), "");
		PrintWriter out = response.getWriter();
		if (!name.equals("")) {
			Role r = new Role();
			r.setName(name);
			service.addRole(r);
			out.write("{\"success\":true,\"msg\":\"添加成功！\"}");
		} else {
			out.write("{\"success\":true,\"msg\":\"操作失败！\"}");
		}
		out.flush();
		out.close();
	}

	public RoleService getService() {
		return service;
	}

	public void setService(RoleService service) {
		this.service = service;
	}
}
