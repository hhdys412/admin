package com.hhdys.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhdys.model.MenuTree;
import com.hhdys.model.PageFunc;
import com.hhdys.model.RoleFuncAss;
import com.hhdys.service.RoleFuncService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("json-default")
@Namespace("/admin")
@ResultPath("/")
@Service
public class RolefuncAction extends ActionSupport {
	@Autowired
	private RoleFuncService rolefuncService;

	private Map<String, List<PageFunc>> map;

	private String msg;
	private String result;

	private int roleId;

	private String funcIds;

	@Action(results = { @Result(name = "success", type = "json") })
	public String selPageFuncs() {
		map = new HashMap<String, List<PageFunc>>();
		List<MenuTree> menuTrees = rolefuncService.getAllMenu();
		for (MenuTree tree : menuTrees) {
			List<PageFunc> pageFuncs = rolefuncService.getPageFuncsByPageId(tree.getId());
			if (pageFuncs != null && pageFuncs.size() != 0) {
				map.put(tree.getName(), pageFuncs);
			}
		}
		return "success";
	}

	@Action(value = "addFuncAss", results = { @Result(name = "success", type = "json") })
	public String addFuncAss() {
		String[] funcid = funcIds.split(",");
		for (String fun : funcid) {
			RoleFuncAss ass = new RoleFuncAss();
			ass.setFuncId(Integer.parseInt(fun));
			ass.setRoleId(roleId);
			rolefuncService.addAss(ass);
		}
		msg = "添加成功";
		result = "success";
		return "success";
	}

	public Map<String, List<PageFunc>> getMap() {
		return map;
	}

	public void setMap(Map<String, List<PageFunc>> map) {
		this.map = map;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@JSON(serialize = false)
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@JSON(serialize = false)
	public String getFuncIds() {
		return funcIds;
	}

	public void setFuncIds(String funcIds) {
		this.funcIds = funcIds;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@JSON(serialize = false)
	public RoleFuncService getRolefuncService() {
		return rolefuncService;
	}

	public void setRolefuncService(RoleFuncService rolefuncService) {
		this.rolefuncService = rolefuncService;
	}
}
