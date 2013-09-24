package com.hhdys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hhdys.dao.AccountMapper;
import com.hhdys.model.Account;
import com.hhdys.model.AccountExample;
@Repository
public class AccountServiceImpl implements AccountService {
	private SqlSession session;

	@Override
	public boolean addUser(Account account) {
		try {
			AccountMapper dao = session.getMapper(AccountMapper.class);
			dao.insert(account);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkUser(String userName, String password) {
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
		}
		return false;
	}

	@Override
	public List<Map<String, String>> getUserList(String condition, int pageSize, int curPage) {
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("condition", condition);
			map.put("curpage", String.valueOf((curPage - 1) * pageSize));
			map.put("pagesize", String.valueOf(pageSize));
			List<Map<String, String>> list = session.selectList("com.hhdys.dao.AccountMapper.select_page", map);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getTotalSize(String condition) {
		try {
			int count = session.selectOne("com.hhdys.dao.AccountMapper.select_page_count", condition);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean delAccount(String ids) {
		try {
			String[] id = ids.split(",");
			List<Integer> list = new ArrayList<Integer>();
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
		}
		return false;
	}

	public SqlSession getSession() {
		return session;
	}

	@Resource(name = "sqlSession")
	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public boolean editUser(Account account) {
		try {
			AccountMapper dao = session.getMapper(AccountMapper.class);
			dao.updateByPrimaryKeySelective(account);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkUserName(String userName) {
		AccountMapper dao = session.getMapper(AccountMapper.class);
		AccountExample example = new AccountExample();
		AccountExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(userName);
		if (dao.selectByExample(example).size() > 0) {
			return true;
		}
		return false;
	}
}
