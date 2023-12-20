package com.qlmh.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qlmh.api.Model.FloorLevel;
import com.qlmh.api.Service.FloorLevelService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/floor-levels")
public class FloorLevelController {
	@Autowired
	FloorLevelService floorLevelService;
	
	// create floor level
	@RequestMapping(value = "" , method = RequestMethod.POST)
	public FloorLevel createFloorLevel(@RequestBody FloorLevel floorLevel) {
		return floorLevelService.createFloorLevel(floorLevel);
	}
	
	// get all floor levels
	@RequestMapping(value = "" , method = RequestMethod.GET)
	public List<FloorLevel> getAllFloorLevels(){
		return floorLevelService.getAllFloorLevels();
	}
}
