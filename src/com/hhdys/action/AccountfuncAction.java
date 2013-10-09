package com.hhdys.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhdys.model.AccountFuncAss;
import com.hhdys.service.AccountFuncService;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("json-default")
@Namespace("/admin")
@ResultPath("/")
@Service
public class AccountfuncAction extends ActionSupport {

	private String funcIds;
	private String msg;
	private String result;
	private int accountId;
	private List<AccountFuncAss> list;

	@Autowired
	private AccountFuncService service;

	@Action(results = { @Result(name = "success", type = "json") })
	public String addAccountFuncAss() {
		String[] funcid = funcIds.split(",");
		service.delAccountFuncByAccountId(accountId);
		for (String fun : funcid) {
			AccountFuncAss ass = new AccountFuncAss();
			ass.setAccountId(accountId);
			ass.setFuncId(Integer.parseInt(fun));
			service.addAccountFunc(ass);
		}
		msg = "添加成功";
		result = "success";
		return "success";
	}

	@Action(value = "getFuncsByRoleId", results = { @Result(name = "success", type = "json") })
	public String getFuncsByRoleId() {
		list = service.getAccountFuncListByAccountId(accountId);
		return "success";
	}

	@JSON(serialize = false)
	public String getFuncIds() {
		return funcIds;
	}

	public void setFuncIds(String funcIds) {
		this.funcIds = funcIds;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@JSON(serialize = false)
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@JSON(serialize = false)
	public AccountFuncService getService() {
		return service;
	}

	public void setService(AccountFuncService service) {
		this.service = service;
	}

	public List<AccountFuncAss> getList() {
		return list;
	}

	public void setList(List<AccountFuncAss> list) {
		this.list = list;
	}

}
