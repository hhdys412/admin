package com.hhdys.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

import com.hhdys.dao.RoleMapper;
import com.hhdys.model.Role;
import com.hhdys.model.RoleExample;

public class RoleServiceImpl implements RoleService {
	@Resource(name = "sqlSession")
	private SqlSession session;

	public SqlSession getSession() {
		return session;
	}

	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<Role> getList() {
		RoleMapper dao = session.getMapper(RoleMapper.class);
		return dao.selectByExample(null);
	}

	@Override
	public void delRoleById(String ids) {
		String[] id = ids.split(",");
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < id.length; i++) {
			list.add(Integer.parseInt(id[i]));
		}
		RoleMapper dao = session.getMapper(RoleMapper.class);
		RoleExample example = new RoleExample();
		RoleExample.Criteria criteria = example.createCriteria();
		criteria.andIdIn(list);
		dao.deleteByExample(example);
	}

	@Override
	public void UpdateRole(Role role) {
		RoleMapper dao = session.getMapper(RoleMapper.class);
		dao.updateByPrimaryKey(role);
	}

	@Override
	public void addRole(Role role) {
		RoleMapper dao = session.getMapper(RoleMapper.class);
		dao.insert(role);
	}
}
