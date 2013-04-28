package com.hhdys.service;

import com.hhdys.model.Department;

public interface DepartmentService {
	public Department getDepartmentById(int id);
	
	public String getDepartmentJsonByParentId(int parentId);
	
	public boolean addDepartment(Department department);
	
	public void delDepartment(int id);
	
	public void updateDepartment(Department department);
	
}
