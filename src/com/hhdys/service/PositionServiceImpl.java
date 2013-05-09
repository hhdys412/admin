package com.hhdys.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

import com.hhdys.dao.PositionMapper;
import com.hhdys.model.Position;
import com.hhdys.model.PositionExample;

public class PositionServiceImpl implements PositionService {
	@Resource(name = "sqlSession")
	private SqlSession session;

	public SqlSession getSession() {
		return session;
	}

	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<Position> getList() {
		PositionMapper dao = session.getMapper(PositionMapper.class);
		return dao.selectByExample(null);
	}

	@Override
	public void delPositionById(String ids) {
		String[] id = ids.split(",");
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < id.length; i++) {
			list.add(Integer.parseInt(id[i]));
		}
		PositionMapper dao = session.getMapper(PositionMapper.class);
		PositionExample example = new PositionExample();
		PositionExample.Criteria criteria = example.createCriteria();
		criteria.andIdIn(list);
		dao.deleteByExample(example);
	}

	@Override
	public void UpdatePosition(Position position) {
		PositionMapper dao=session.getMapper(PositionMapper.class);
		dao.updateByPrimaryKey(position);
	}

	@Override
	public void addPosition(Position position) {
		PositionMapper dao=session.getMapper(PositionMapper.class);
		dao.insert(position);
	}
}
