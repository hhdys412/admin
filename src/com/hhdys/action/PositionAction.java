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
import org.json.JSONObject;

import com.hhdys.model.Position;
import com.hhdys.service.PositionService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/admin")
@ResultPath("/")
public class PositionAction extends ActionSupport {
	@Resource(name = "position")
	private PositionService service;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();

	public PositionService getService() {
		return service;
	}

	public void setService(PositionService service) {
		this.service = service;
	}

	public void getList() throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		List<Position> list = service.getList();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("rows", list);
		PrintWriter out = response.getWriter();
		out.write(jsonObject.toString());
		out.flush();
		out.close();
	}

	public void delPosition() throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String ids = request.getParameter("id");
		PrintWriter out = response.getWriter();
		service.delPositionById(ids);
		out.write("{\"success\":true,\"msg\":\"删除成功！\"}");
		out.flush();
		out.close();
	}
}
