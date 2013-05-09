package com.hhdys.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;

import com.hhdys.service.MenuTreeService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/admin")
@ResultPath("/")
public class MenutreeAction extends ActionSupport {
	@Resource(name = "menutree")
	private MenuTreeService service;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();

	public void getList() throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			list.add(i);
		}
		PrintWriter out = response.getWriter();
		out.write("["+service.getList(list,0)+"]");
		out.flush();
		out.close();
	}

	public MenuTreeService getService() {
		return service;
	}

	public void setService(MenuTreeService service) {
		this.service = service;
	}
}
