package com.hhdys.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.hhdys.model.Department;
import com.hhdys.service.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/admin")
@ResultPath("/")
public class DepartmentAction extends ActionSupport {
	@Resource(name = "department")
	private DepartmentService service;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();

	public DepartmentService getService() {
		return service;
	}

	public void setService(DepartmentService service) {
		this.service = service;
	}

	public void getDepartmentTree() throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.write("[" + service.getDepartmentJsonByParentId(0) + "]");
		out.flush();
		out.close();
	}
}
