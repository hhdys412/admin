package com.hhdys.service;

import java.util.List;
import java.util.Map;

import com.hhdys.model.Account;

public interface AccountService {
	public boolean addUser(Account account);
	
	public boolean editUser(Account account);
	
	public boolean checkUser(String userName,String password);
	
	public List<Map<String, String>> getUserList(String condition,int pageSize,int curPage);
	
	public int getTotalSize(String condition);
	
	
	public boolean delAccount(String ids);
	/**
	 * 检查用户名是否已经存在
	 * @param userName 用户名
	 * @return true 已存在
	 */
	public boolean checkUserName(String userName);
}
