package com.hhdys.service;

import java.util.List;

import com.hhdys.model.Role;

public interface RoleService {
	public List<Role> getList();

	public void delRoleById(String ids);

	public void UpdateRole(Role role);

	public void addRole(Role role);
}
