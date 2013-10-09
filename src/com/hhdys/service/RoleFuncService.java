package com.hhdys.service;

import java.util.List;

import com.hhdys.model.MenuTree;
import com.hhdys.model.PageFunc;
import com.hhdys.model.RoleFuncAss;

public interface RoleFuncService {
	public List<MenuTree> getAllMenu();

	public List<PageFunc> getPageFuncsByPageId(int pageId);

	public void addAss(RoleFuncAss ass);

	List<RoleFuncAss> getPageFuncsByRoleId(int roleId);

	void delFuncByRoleId(int roleId);
}
