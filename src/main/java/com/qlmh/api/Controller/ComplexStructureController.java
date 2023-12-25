package com.qlmh.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qlmh.api.DTO.ComplexStructureDTO;
import com.qlmh.api.Model.ComplexStructure;
import com.qlmh.api.Service.ComplexStructureService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/comp-structures")
public class ComplexStructureController {
	@Autowired
	ComplexStructureService complexStructureService;
	
	// create
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ComplexStructure create(@RequestBody ComplexStructureDTO complexStructure) {
		return complexStructureService.create(complexStructure);
	}
	
	// get all complex structures
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<ComplexStructure> getAllComplexStructures(){
		return complexStructureService.getAllComplexStructures();
	}
	
	// get all by floor id
	@RequestMapping(value = "/floor/{id}", method = RequestMethod.GET)
	public List<ComplexStructure> getAllByFloorID(@PathVariable(value = "id") Integer floorID) {
		return complexStructureService.getAllByFloorID(floorID);
	}
}
