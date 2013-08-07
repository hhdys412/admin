package com.hhdys.service;

import java.util.List;

import com.hhdys.model.MenuTree;

public interface MenuTreeService {
	public String getList(List<Integer> list, int parentId,int flag);

	public void addMenu(MenuTree tree);
	
	public void delMenu(int id);
	public void updateMenu(MenuTree tree);
}
