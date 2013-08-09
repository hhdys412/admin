package com.hhdys.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.json.annotations.JSON;

import com.hhdys.model.DepartRoleAss;
import com.hhdys.service.DepartRoleAssService;
import com.opensymphony.xwork2.ActionSupport;



@ParentPackage("json-default")
@Namespace("/admin")
@ResultPath("/")
public class DepartroleassAction extends ActionSupport {
	@Resource(name = "departroleass")
	private DepartRoleAssService service;
	private String roleid;
	private int departmentid;
	private List<DepartRoleAss> assList;

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();

	public void addAss() throws IOException {
		Pattern pattern = Pattern.compile("\\d");
		Matcher matcher = pattern.matcher(roleid);
		service.delDepartRoleAss(departmentid);// 添加之前先清空之前的角色
		service.delSonDepartRoleAss(departmentid);
		while (matcher.find()) {
			int roleId = Integer.parseInt(matcher.group());
			DepartRoleAss ass = new DepartRoleAss();
			ass.setDepartmentId(departmentid);
			ass.setRoleId(roleId);
			service.addDepartRoleAss(ass);
			service.addSonDepartRoleAss(departmentid, roleId);
		}
		PrintWriter out = response.getWriter();
		out.write("success");
		out.flush();
		out.close();
	}

	@Action(results = { @Result(name = "success", type = "json") })
	public String selectAss() {
		assList=service.getAssByDepartIdAndRoleId(departmentid);
		return "success";
	}

	@JSON(serialize = false)
	public DepartRoleAssService getService() {
		return service;
	}

	public void setService(DepartRoleAssService service) {
		this.service = service;
	}

	@JSON(serialize = false)
	public int getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}

	@JSON(serialize = false)
	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public List<DepartRoleAss> getAssList() {
		return assList;
	}

	public void setAssList(List<DepartRoleAss> assList) {
		this.assList = assList;
	}

}
