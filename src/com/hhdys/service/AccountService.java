package com.hhdys.service;

import java.util.List;

import com.hhdys.model.Account;

public interface AccountService {
	public boolean addUser(Account account);
	
	public boolean checkUser(String userName,String password);
	
	public List<Account> getUserList(String condition,int pageSize,int curPage);
	
	public int getTotalSize(String condition);
	
	
	public boolean delAccount(String ids);
}
