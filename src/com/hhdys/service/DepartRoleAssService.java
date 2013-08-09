package com.hhdys.service;

import java.util.List;

import com.hhdys.model.DepartRoleAss;

public interface DepartRoleAssService {
	public void addDepartRoleAss(DepartRoleAss ass);
	
	public void addSonDepartRoleAss(int parentId, int roleId);
	
	public void delDepartRoleAss(int departmentId);
	
	public List<DepartRoleAss> getAssByDepartIdAndRoleId(int departmentId);
	public void delSonDepartRoleAss(int parentId);
}
