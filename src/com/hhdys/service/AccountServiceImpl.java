package com.hhdys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hhdys.dao.AccountMapper;
import com.hhdys.model.Account;
import com.hhdys.model.AccountExample;

public class AccountServiceImpl implements AccountService {
	private SqlSessionFactory factory;

	@Override
	public boolean addUser(Account account) {
		SqlSession session = factory.openSession();
		try {
			AccountMapper dao = session.getMapper(AccountMapper.class);
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

	@Override
	public boolean checkUser(String userName, String password) {
		SqlSession session = factory.openSession();
		try {
			AccountExample example = new AccountExample();
			AccountExample.Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(userName);
			criteria.andPasswordEqualTo(password);
			AccountMapper dao = session.getMapper(AccountMapper.class);
			if (dao.selectByExample(example).size() == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<Account> getUserList(String condition, int pageSize, int curPage) {
		SqlSession session = factory.openSession();
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("condition", condition);
			map.put("curpage", String.valueOf((curPage - 1) * pageSize));
			map.put("pagesize", String.valueOf(pageSize));
			List<Account> list = session.selectList("com.hhdys.dao.AccountMapper.select_page", map);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public int getTotalSize(String condition) {
		SqlSession session = factory.openSession();
		try {
			int count = session.selectOne("com.hhdys.dao.AccountMapper.select_page_count", condition);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return 0;
	}

	@Override
	public boolean delAccount(String ids) {
		SqlSession session = factory.openSession();
		try {
			String[] id = ids.split(",");
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < id.length; i++) {
				list.add(Integer.parseInt(id[i]));
			}
			AccountMapper dao = session.getMapper(AccountMapper.class);
			AccountExample example = new AccountExample();
			AccountExample.Criteria criteria = example.createCriteria();
			criteria.andIdIn(list);
			dao.deleteByExample(example);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}
}
