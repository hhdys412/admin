package com.hhdys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhdys.dao.AccountFuncAssMapper;
import com.hhdys.model.AccountFuncAss;
import com.hhdys.model.AccountFuncAssExample;

@Service
public class AccountFuncServiceImpl implements AccountFuncService {

	@Autowired
	private AccountFuncAssMapper dao;

	@Override
	public void addAccountFunc(AccountFuncAss ass) {
		dao.insert(ass);
	}

	public AccountFuncAssMapper getDao() {
		return dao;
	}

	public void setDao(AccountFuncAssMapper dao) {
		this.dao = dao;
	}

	@Override
	public void delAccountFuncByAccountId(int accountId) {
		AccountFuncAssExample example = new AccountFuncAssExample();
		AccountFuncAssExample.Criteria criteria = example.createCriteria();
		criteria.andAccountIdEqualTo(accountId);
		dao.deleteByExample(example);
	}

	@Override
	public List<AccountFuncAss> getAccountFuncListByAccountId(int accountId) {
		AccountFuncAssExample example = new AccountFuncAssExample();
		AccountFuncAssExample.Criteria criteria = example.createCriteria();
		criteria.andAccountIdEqualTo(accountId);
		return dao.selectByExample(example);
	}

}
