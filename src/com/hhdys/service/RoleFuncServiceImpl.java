package com.hhdys.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hhdys.dao.MenuTreeMapper;
import com.hhdys.dao.PageFuncMapper;
import com.hhdys.dao.RoleFuncAssMapper;
import com.hhdys.model.MenuTree;
import com.hhdys.model.PageFunc;
import com.hhdys.model.PageFuncExample;
import com.hhdys.model.RoleFuncAss;
import com.hhdys.model.RoleFuncAssExample;

@Repository
public class RoleFuncServiceImpl implements RoleFuncService {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private RoleFuncAssMapper roleFuncDao;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<MenuTree> getAllMenu() {
		MenuTreeMapper dao = sqlSession.getMapper(MenuTreeMapper.class);
		return dao.selectByExample(null);
	}

	@Override
	public List<PageFunc> getPageFuncsByPageId(int pageId) {
		PageFuncExample example = new PageFuncExample();
		PageFuncExample.Criteria criteria = example.createCriteria();
		criteria.andPageIdEqualTo(pageId);
		PageFuncMapper dao = sqlSession.getMapper(PageFuncMapper.class);
		return dao.selectByExample(example);
	}

	public RoleFuncAssMapper getRoleFuncDao() {
		return roleFuncDao;
	}

	public void setRoleFuncDao(RoleFuncAssMapper roleFuncDao) {
		this.roleFuncDao = roleFuncDao;
	}

	@Override
	public void addAss(RoleFuncAss ass) {
		roleFuncDao.insert(ass);
	}

	@Override
	public List<RoleFuncAss> getPageFuncsByRoleId(int roleId) {
		RoleFuncAssExample example = new RoleFuncAssExample();
		RoleFuncAssExample.Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		return roleFuncDao.selectByExample(example);
	}

	@Override
	public void delFuncByRoleId(int roleId) {
		RoleFuncAssExample example = new RoleFuncAssExample();
		RoleFuncAssExample.Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		roleFuncDao.deleteByExample(example);
	}
}
