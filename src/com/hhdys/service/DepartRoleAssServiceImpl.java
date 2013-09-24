package com.hhdys.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hhdys.dao.DepartRoleAssMapper;
import com.hhdys.dao.DepartmentMapper;
import com.hhdys.model.DepartRoleAss;
import com.hhdys.model.DepartRoleAssExample;
import com.hhdys.model.Department;
import com.hhdys.model.DepartmentExample;
@Repository
public class DepartRoleAssServiceImpl implements DepartRoleAssService {
	@Resource(name = "sqlSession")
	private SqlSession session;

	@Override
	public void addDepartRoleAss(DepartRoleAss ass) {
		DepartRoleAssMapper dao = session.getMapper(DepartRoleAssMapper.class);
		dao.insert(ass);
	}

	public SqlSession getSession() {
		return session;
	}

	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public void addSonDepartRoleAss(int parentId, int roleId) {
		DepartmentMapper departmentDao = session.getMapper(DepartmentMapper.class);
		DepartmentExample example = new DepartmentExample();
		DepartmentExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<Department> list = departmentDao.selectByExample(example);
		if (list.size() > 0) {
			for (Department m : list) {
				DepartRoleAss ass = new DepartRoleAss();
				int departmentId = m.getId();
				ass.setDepartmentId(departmentId);
				ass.setRoleId(roleId);
				addDepartRoleAss(ass);
				addSonDepartRoleAss(departmentId, roleId);
			}
		}
	}

	@Override
	public void delDepartRoleAss(int departmentId) {
		DepartRoleAssMapper dao = session.getMapper(DepartRoleAssMapper.class);
		DepartRoleAssExample example = new DepartRoleAssExample();
		DepartRoleAssExample.Criteria criteria = example.createCriteria();
		criteria.andDepartmentIdEqualTo(departmentId);
		dao.deleteByExample(example);
	}
	@Override
	public void delSonDepartRoleAss(int parentId){
		DepartmentMapper departmentDao = session.getMapper(DepartmentMapper.class);
		DepartmentExample example = new DepartmentExample();
		DepartmentExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<Department> list = departmentDao.selectByExample(example);
		if(list.size()>0){
			for (Department m : list) {
				delDepartRoleAss(m.getId());
				delSonDepartRoleAss(m.getId());
			}
		}
	}

	@Override
	public List<DepartRoleAss> getAssByDepartIdAndRoleId(int departmentId) {
		DepartRoleAssMapper dao = session.getMapper(DepartRoleAssMapper.class);
		DepartRoleAssExample example = new DepartRoleAssExample();
		DepartRoleAssExample.Criteria criteria = example.createCriteria();
		criteria.andDepartmentIdEqualTo(departmentId);
		return dao.selectByExample(example);
	}
}
