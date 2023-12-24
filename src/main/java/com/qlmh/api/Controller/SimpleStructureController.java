package com.qlmh.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.qlmh.api.DTO.SimpleStructureDTO;
import com.qlmh.api.DTO.SimpleStructureResponseDTO;
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
	public SimpleStructure create(@RequestBody SimpleStructureDTO simpleStructure) {
		return simpleStructureService.create(simpleStructure);
	}
	
	//read all
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<SimpleStructureResponseDTO> getAll() {
		return simpleStructureService.getAll();
	}
	
	//read by id
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public SimpleStructureResponseDTO getById(@PathVariable(value = "id") Integer id) {
		return simpleStructureService.getById(id);
	}
	
	//find all by floorlevel
	@RequestMapping(value = "/floorlevel/{id}", method = RequestMethod.GET)
	public List<SimpleStructureResponseDTO> getAllByFloorID(@PathVariable(value = "id") Integer floorID) {
		return simpleStructureService.getAllByFloorID(floorID);
	}
	
	//delete
	@RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") Integer id) {
		simpleStructureService.delete(id);
	}
}
