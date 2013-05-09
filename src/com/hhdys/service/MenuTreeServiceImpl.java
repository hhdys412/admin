package com.hhdys.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

import com.hhdys.dao.MenuTreeMapper;
import com.hhdys.model.MenuTree;
import com.hhdys.model.MenuTreeExample;

public class MenuTreeServiceImpl implements MenuTreeService {
	@Resource(name = "sqlSession")
	private SqlSession session;

	@Override
	public String getList(List<Integer> list, int parentId) {
		MenuTreeMapper dao = session.getMapper(MenuTreeMapper.class);
		MenuTreeExample example = new MenuTreeExample();
		MenuTreeExample.Criteria criteria = example.createCriteria();
		// criteria.andIdIn(list);
		criteria.andParentIdEqualTo(parentId);
		criteria.andIsShowEqualTo(0);
		List<MenuTree> reusltList = dao.selectByExample(example);
		StringBuilder stringBuilder = new StringBuilder();
		Iterator<MenuTree> iter = reusltList.iterator();
		while (iter.hasNext()) {
			MenuTree menuTree = iter.next();
			if (!list.contains(menuTree.getId())) {
				continue;
			}
			stringBuilder.append("{\"id\":" + menuTree.getId() + ",\"text\":\"" + menuTree.getName()
					+ "\",\"attributes\":{\"url\":\"" + menuTree.getUrl() + "\"}");
			String str = null;
			if ((str = getList(list, menuTree.getId())) != null) {
				stringBuilder.append(",\"children\":[" + str + "]");
			}
			stringBuilder.append("},");

		}
		if (stringBuilder.length() > 0) {
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
			String result = stringBuilder.toString();
			return result;
		}
		return null;
	}

	public SqlSession getSession() {
		return session;
	}

	public void setSession(SqlSession session) {
		this.session = session;
	}

}
