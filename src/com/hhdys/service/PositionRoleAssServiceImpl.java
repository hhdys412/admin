package com.hhdys.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.hhdys.dao.PositionRoleAssMapper;
import com.hhdys.model.PositionRoleAss;
import com.hhdys.model.PositionRoleAssExample;

public class PositionRoleAssServiceImpl implements PositionRoleAssService {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addPositionRoleAss(PositionRoleAss ass) {
		PositionRoleAssMapper dao = sqlSession.getMapper(PositionRoleAssMapper.class);
		dao.insert(ass);
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<PositionRoleAss> selectAssList(int positionId) {
		PositionRoleAssExample example=new PositionRoleAssExample();
		PositionRoleAssExample.Criteria criteria=example.createCriteria();
		criteria.andPositionIdEqualTo(positionId);
		PositionRoleAssMapper dao = sqlSession.getMapper(PositionRoleAssMapper.class);
		return dao.selectByExample(example);
	}

	@Override
	public void delAss(int positionId) {
		PositionRoleAssExample example=new PositionRoleAssExample();
		PositionRoleAssExample.Criteria criteria=example.createCriteria();
		criteria.andPositionIdEqualTo(positionId);
		PositionRoleAssMapper dao = sqlSession.getMapper(PositionRoleAssMapper.class);
		dao.deleteByExample(example);
	}

}
