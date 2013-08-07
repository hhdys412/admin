package com.hhdys.service;

import java.util.List;

import com.hhdys.model.PageFunc;

public interface PageFuncService {
	public void addFunc(PageFunc func);

	public List<PageFunc> getFuncList(int pageId);
	
	public void delFunc(int id);
}
