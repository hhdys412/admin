package com.hhdys.service;

import com.hhdys.model.Department;

public interface DepartmentService {
	public Department getDepartmentById(int id);
	
	public String getDepartmentJsonByParentId(int parentId);
}
