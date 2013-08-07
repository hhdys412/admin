package com.hhdys.service;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

public class PageFuncServiceImpl implements PageFuncService {
	
	@Resource(name="sqlSession")
	private SqlSession session;

	public SqlSession getSession() {
		return session;
	}

	public void setSession(SqlSession session) {
		this.session = session;
	}

}
