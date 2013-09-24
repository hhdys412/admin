package com.hhdys.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hhdys.dao.PageFuncMapper;
import com.hhdys.model.PageFunc;
import com.hhdys.model.PageFuncExample;
@Repository
public class PageFuncServiceImpl implements PageFuncService {

	@Resource(name = "sqlSession")
	private SqlSession session;

	public SqlSession getSession() {
		return session;
	}

	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public void addFunc(PageFunc func) {
		PageFuncMapper dao = session.getMapper(PageFuncMapper.class);
		dao.insert(func);

	}

	@Override
	public List<PageFunc> getFuncList(int pageId) {
		PageFuncMapper dao = session.getMapper(PageFuncMapper.class);
		PageFuncExample example = new PageFuncExample();
		PageFuncExample.Criteria criteria = example.createCriteria();
		criteria.andPageIdEqualTo(pageId);
		List<PageFunc> list = dao.selectByExample(example);
		return list;
	}

	@Override
	public void delFunc(int id) {
		PageFuncMapper dao = session.getMapper(PageFuncMapper.class);
		dao.deleteByPrimaryKey(id);
	}

}
