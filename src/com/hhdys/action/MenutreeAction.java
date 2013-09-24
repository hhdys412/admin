package com.hhdys.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.util.StringUtil;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhdys.model.MenuTree;
import com.hhdys.service.MenuTreeService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/admin")
@ResultPath("/")
@Service
public class MenutreeAction extends ActionSupport {
	@Autowired
	private MenuTreeService service;
	

	public void getList() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String flagStr=request.getParameter("flag");
		int flag=0;
		if(flagStr!=null&&flagStr.equals("1")){
			flag=1;
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 100; i++) {//有哪些权限  显示哪些目录
			list.add(i);
		}
		PrintWriter out = response.getWriter();
		out.write("[" + service.getList(list, 0,flag) + "]");
		out.flush();
		out.close();
	}

	public void addTree() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String newUrlText = request.getParameter("newUrlText");
		String newUrl = request.getParameter("newUrl");
		String hidId = request.getParameter("hidId");
		String rdisplay = request.getParameter("rdisplay");
		String rNewW = request.getParameter("rNewW");
		MenuTree tree = new MenuTree();
		tree.setIsShow(Integer.parseInt(rdisplay));
		tree.setName(newUrlText);
		tree.setNewWindows(Integer.parseInt(rNewW));
		tree.setParentId(Integer.parseInt(hidId));
		tree.setUrl(newUrl);
		service.addMenu(tree);
		PrintWriter out = response.getWriter();
		out.write("success");
		out.flush();
		out.close();
	}
	
	public void updateTree() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String newUrlText = request.getParameter("selUrlText");
		String newUrl = request.getParameter("selUrl");
		String hidId = request.getParameter("hidId");
		String rdisplay = request.getParameter("rdisplay");
		String rNewW = request.getParameter("rNewW");
		MenuTree tree = new MenuTree();
		tree.setIsShow(Integer.parseInt(rdisplay));
		tree.setName(newUrlText);
		tree.setNewWindows(Integer.parseInt(rNewW));
		tree.setId(Integer.parseInt(hidId));
		tree.setUrl(newUrl);
		service.updateMenu(tree);
		PrintWriter out = response.getWriter();
		out.write("success");
		out.flush();
		out.close();
	}
	
	public void delTree() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String hidId = request.getParameter("id");
		service.delMenu(Integer.parseInt(hidId));
		PrintWriter out = response.getWriter();
		out.write("success");
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
