package com.hhdys.service;

import java.util.List;

import com.hhdys.model.Position;

public interface PositionService {
	public List<Position> getList();
	
	public void delPositionById(String ids);
	
	public void UpdatePosition(Position position);
	
	public void addPosition(Position position);
}
