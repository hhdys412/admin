package com.hhdys.service;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

import com.hhdys.dao.DepartmentMapper;
import com.hhdys.model.Department;
import com.hhdys.model.DepartmentExample;

public class DepartmentServiceImpl implements DepartmentService {
	@Resource(name = "sqlSession")
	private SqlSession session;

	public SqlSession getSession() {
		return session;
	}

	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public Department getDepartmentById(int id) {
		DepartmentMapper dao = session.getMapper(DepartmentMapper.class);
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public String getDepartmentJsonByParentId(int parentId) {
		StringBuilder stringBuilder = new StringBuilder();
		DepartmentMapper dao = session.getMapper(DepartmentMapper.class);
		DepartmentExample example = new DepartmentExample();
		DepartmentExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<Department> list = dao.selectByExample(example);
		Iterator<Department> iter = list.iterator();
		while (iter.hasNext()) {
			Department d = iter.next();
			stringBuilder.append("{\"id\":" + d.getId() + ",\"text\":\"" + d.getName() + "\"");
			String str = null;
			if ((str = getDepartmentJsonByParentId(d.getId())) != null) {
				stringBuilder.append(",\"children\":[" + str + "]");
			}
			stringBuilder.append("},");
		}
		if (stringBuilder.length() > 0) {
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
			String result = stringBuilder.toString();
			return result;
		}
		return null;
	}

}
