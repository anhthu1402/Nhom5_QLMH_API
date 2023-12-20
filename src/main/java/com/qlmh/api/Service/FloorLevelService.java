package com.qlmh.api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlmh.api.Model.FloorLevel;
import com.qlmh.api.Repository.FloorLevelRepository;

@Service
public class FloorLevelService {
	@Autowired
	FloorLevelRepository floorLevelRepository;
	
	// create floor level
	public FloorLevel createFloorLevel(FloorLevel floorLevel) {
		FloorLevel floorLevel2 = floorLevelRepository.findByName(floorLevel.getName().trim());
		if(floorLevel2 != null) {
			return floorLevel2;
		}
		return floorLevelRepository.save(floorLevel);
	}
	
	// get all floor levels
	public List<FloorLevel> getAllFloorLevels(){
		return floorLevelRepository.findAll();
	}
}
