package com.hhdys.service;

import java.util.List;

import com.hhdys.model.AccountFuncAss;

public interface AccountFuncService {
	public void addAccountFunc(AccountFuncAss ass);

	public void delAccountFuncByAccountId(int accountId);

	public List<AccountFuncAss> getAccountFuncListByAccountId(int accountId);
}
