package com.hhdys.action;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import com.hhdys.model.PositionRoleAss;
import com.hhdys.service.PositionRoleAssService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("json-default")
@Namespace("/admin")
@ResultPath("/")
public class PositionroleAction extends ActionSupport {
	@Autowired
	private PositionRoleAssService postionroleass;
	private String result,msg;
	private String roleId;
	private int hidPositionId;
	private List<PositionRoleAss> assList;
	@Action(results={@Result(type="json",name="success")})
	public String addAss(){
		postionroleass.delAss(hidPositionId);;
		Pattern pattern = Pattern.compile("\\d");
		Matcher matcher = pattern.matcher(roleId);
		while (matcher.find()) {
			int roleIdint = Integer.parseInt(matcher.group());
			PositionRoleAss ass=new PositionRoleAss();
			ass.setPositionId(hidPositionId);
			ass.setRoleId(roleIdint);
			postionroleass.addPositionRoleAss(ass);
		}
		result="success";
		msg="添加成功!";
		return "success";
	}
	@Action(value="selectAss",results = { @Result(name = "success", type = "json") })
	public String selectAss() {
		assList=postionroleass.selectAssList(hidPositionId);
		return "success";
	}
	
	@JSON(serialize=false)
	public PositionRoleAssService getPostionroleass() {
		return postionroleass;
	}
	public void setPostionroleass(PositionRoleAssService postionroleass) {
		this.postionroleass = postionroleass;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@JSON(serialize=false)
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	@JSON(serialize=false)
	public int getHidPositionId() {
		return hidPositionId;
	}
	public void setHidPositionId(int hidPositionId) {
		this.hidPositionId = hidPositionId;
	}
	public List<PositionRoleAss> getAssList() {
		return assList;
	}
	public void setAssList(List<PositionRoleAss> assList) {
		this.assList = assList;
	}
}
