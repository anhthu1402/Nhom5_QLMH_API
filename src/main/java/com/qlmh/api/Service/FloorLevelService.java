package com.qlmh.api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlmh.api.Model.Construction;
import com.qlmh.api.Model.FloorLevel;
import com.qlmh.api.Repository.ConstructionRepository;
import com.qlmh.api.Repository.FloorLevelRepository;

@Service
public class FloorLevelService {
	@Autowired
	FloorLevelRepository floorLevelRepository;
	
	@Autowired
	ConstructionRepository constructionRepository;
	
	// create floor level
	public FloorLevel createFloorLevel(FloorLevel floorLevel, Integer constructionId) {
		Construction construction = constructionRepository.findById(constructionId).get();
		FloorLevel floorLevel2 = floorLevelRepository.findByName(floorLevel.getName().trim());
		if(floorLevel2 != null) {
			if(floorLevel2.getConstruction().getId() == constructionId) {
				return floorLevel2;
			}
		}
		floorLevel.setConstruction(construction);
		return floorLevelRepository.save(floorLevel);
	}
	
	// get all floor levels
	public List<FloorLevel> getAllFloorLevels(){
		return floorLevelRepository.findAll();
	}
}
