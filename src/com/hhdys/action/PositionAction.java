package com.hhdys.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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

import com.hhdys.model.Position;
import com.hhdys.service.PositionService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/admin")
@ResultPath("/")
@Service
public class PositionAction extends ActionSupport {
	@Autowired
	private PositionService service;
	

	public PositionService getService() {
		return service;
	}

	public void setService(PositionService service) {
		this.service = service;
	}

	public void getList() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
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
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String ids = request.getParameter("id");
		PrintWriter out = response.getWriter();
		service.delPositionById(ids);
		out.write("{\"success\":true,\"msg\":\"删除成功！\"}");
		out.flush();
		out.close();
	}

	public void updatePosition() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = StringUtils.defaultString(request.getParameter("id"), "");
		String position = StringUtils.defaultString(request.getParameter("position"), "");
		PrintWriter out = response.getWriter();
		if (!id.equals("") && !position.equals("")) {
			Position p = new Position();
			p.setId(Integer.parseInt(id));
			p.setName(position);
			service.UpdatePosition(p);
			out.write("{\"success\":true,\"msg\":\"修改成功！\"}");
		} else {
			out.write("{\"success\":true,\"msg\":\"操作失败！\"}");
		}
		out.flush();
		out.close();
	}

	public void addPosition() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String position = StringUtils.defaultString(request.getParameter("name"), "");
		PrintWriter out = response.getWriter();
		if (!position.equals("")) {
			Position p = new Position();
			p.setName(position);
			service.addPosition(p);
			out.write("{\"success\":true,\"msg\":\"添加成功！\"}");
		} else {
			out.write("{\"success\":true,\"msg\":\"操作失败！\"}");
		}
		out.flush();
		out.close();
	}
}
