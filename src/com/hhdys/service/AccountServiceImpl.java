package com.hhdys.service;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hhdys.dao.AccountMapper;
import com.hhdys.model.Account;

public class AccountServiceImpl implements AccountService {
	private SqlSessionFactory factory;

	@Override
	public boolean addUser() {
		SqlSession session = factory.openSession();
		try {
			AccountMapper dao = session.getMapper(AccountMapper.class);
			Account account = new Account();
			account.setUsername("hhdys");
			account.setPassword("123");
			account.setName("坏坏的忧伤");
			dao.insert(account);
			session.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	public SqlSessionFactory getFactory() {
		return factory;
	}

	@Resource(name = "sqlSessionFactory")
	public void setFactory(SqlSessionFactory factory) {
		this.factory = factory;
	}
}
