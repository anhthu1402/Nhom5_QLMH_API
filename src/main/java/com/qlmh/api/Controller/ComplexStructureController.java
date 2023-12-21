package com.qlmh.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public ComplexStructure create(@RequestBody ComplexStructure complexStructure) {
		return complexStructureService.create(complexStructure);
	}
	
	// get all complex structures
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<ComplexStructure> getAllComplexStructures(){
		return complexStructureService.getAllComplexStructures();
	}
}
