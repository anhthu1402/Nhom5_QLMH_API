package com.qlmh.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.qlmh.api.DTO.SimpleStructureDTO;
import com.qlmh.api.Model.SimpleStructure;
import com.qlmh.api.Service.SimpleStructureService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/simp-structures")
public class SimpleStructureController {
	@Autowired
	SimpleStructureService simpleStructureService;
	
	// create
	@RequestMapping(value = "", method = RequestMethod.POST)
	public SimpleStructure create(SimpleStructureDTO simpleStructure) {
		return simpleStructureService.create(simpleStructure);
	}
	
	//read all
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<SimpleStructure> getAllSimpleStructure() {
		return simpleStructureService.getAllSimpleStructure();
	}
	
	//read by id
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public SimpleStructure getSimpleStructureById(@PathVariable(value = "id") Integer id) {
		return simpleStructureService.getSimpleStructureById(id);
	}
	
	//find all by floorlevel
	@RequestMapping(value = "/floorlevel/{id}", method = RequestMethod.GET)
	public List<SimpleStructure> findAllSimpleStructureByFloorLevel(@PathVariable(value = "id") Integer floorID) {
		return simpleStructureService.findAllSimpleStructureByFloorLevel(floorID);
	}
	
	//delete
	@RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
	public void deleteSimpleStructure(@PathVariable(value = "id") Integer id) {
		simpleStructureService.deleteSimpleStructure(id);
	}
}
