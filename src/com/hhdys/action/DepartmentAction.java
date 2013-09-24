package com.hhdys.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhdys.model.Department;
import com.hhdys.service.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/admin")
@ResultPath("/")
@Service
public class DepartmentAction extends ActionSupport {
	@Autowired
	private DepartmentService service;
	

	public DepartmentService getService() {
		return service;
	}

	public void setService(DepartmentService service) {
		this.service = service;
	}

	public void getDepartmentTree() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.write("[" + service.getDepartmentJsonByParentId(0) + "]");
		out.flush();
		out.close();
	}

	public void addDepartment() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("hidId");
		String name = request.getParameter("department");
		PrintWriter out = response.getWriter();
		if (id != null && !id.equals("") && name != null && !name.equals("")) {
			Department department = new Department();
			department.setName(name);
			department.setParentId(Integer.parseInt(id));
			if (service.addDepartment(department)) {
				out.write("操作成功！");
			}
		} else {
			out.write("操作失败！");
		}
	}

	public void delDepartment() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("hidId");
		PrintWriter out = response.getWriter();
		if (id != null && !id.equals("")) {
			service.delDepartment(Integer.parseInt(id));
			out.write("操作成功！");
		} else {
			out.write("操作失败！");
		}
	}

	public void updateDepartment() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("hidId");
		String name = request.getParameter("selDepart");
		PrintWriter out = response.getWriter();
		if (id != null && !id.equals("") && name != null && !name.equals("")) {
			Department department = new Department();
			department.setName(name);
			department.setId(Integer.parseInt(id));
			service.updateDepartment(department);
			out.write("操作成功！");
		} else {
			out.write("操作失败！");
		}
	}
}
