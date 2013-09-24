package com.hhdys.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhdys.model.PageFunc;
import com.hhdys.service.PageFuncService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/admin")
@ResultPath("/")
@Service
public class PagefuncAction extends ActionSupport {

	private static final long serialVersionUID = 8444283310965361332L;
	@Autowired
	private PageFuncService service;

	
	private PageFunc pageFunc;
	private int id;

	public PageFuncService getService() {
		return service;
	}

	public void setService(PageFuncService service) {
		this.service = service;
	}

	public void addFunc() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		service.addFunc(pageFunc);
		PrintWriter out = response.getWriter();
		out.write("success");
		out.flush();
		out.close();
	}

	public void getFuncList() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		List<PageFunc> list = service.getFuncList(pageFunc.getPageId());
		JSONArray jsonArray = new JSONArray(list);
		PrintWriter out = response.getWriter();
		out.write(jsonArray.toString());
		out.flush();
		out.close();
	}
	
	public void delFunc() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		service.delFunc(id);
		PrintWriter out = response.getWriter();
		out.write("success");
		out.flush();
		out.close();
	}

	public PageFunc getPageFunc() {
		return pageFunc;
	}

	public void setPageFunc(PageFunc pageFunc) {
		this.pageFunc = pageFunc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
