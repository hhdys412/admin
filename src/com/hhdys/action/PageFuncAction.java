package com.hhdys.action;

import javax.annotation.Resource;

import com.hhdys.service.PageFuncService;
import com.opensymphony.xwork2.ActionSupport;

public class PageFuncAction extends ActionSupport {

	private static final long serialVersionUID = 8444283310965361332L;
	@Resource(name = "pagefunc")
	private PageFuncService service;

	public PageFuncService getService() {
		return service;
	}

	public void setService(PageFuncService service) {
		this.service = service;
	}

}
