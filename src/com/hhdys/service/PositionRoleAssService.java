package com.hhdys.service;

import java.util.List;

import com.hhdys.model.PositionRoleAss;

public interface PositionRoleAssService {
	public void addPositionRoleAss(PositionRoleAss ass);
	
	public List<PositionRoleAss> selectAssList(int positionId);
	
	public void delAss(int positionId);
}
