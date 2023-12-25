package com.qlmh.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qlmh.api.DTO.SimpleBodyDTO;
import com.qlmh.api.DTO.SimpleBodyPropDTO;
import com.qlmh.api.Model.SimpleBody;
import com.qlmh.api.Service.SimpleBodyService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/simp-bodies")
public class SimpleBodyController {
	@Autowired 
	SimpleBodyService simpleBodyService;
	
	// create
	@RequestMapping(value = "/face/{face-id}", method = RequestMethod.POST)
	public SimpleBodyDTO create(@RequestBody SimpleBody simpleBody, @PathVariable(value = "face-id") Integer faceId) {
		return simpleBodyService.create(simpleBody, faceId);
	}
	
	// get all by complex structure id
	@RequestMapping(value = "/comp-structure/{id}", method = RequestMethod.GET)
	public List<SimpleBodyPropDTO> getAllByCompStructure(@PathVariable(value = "id") Integer id){
		return simpleBodyService.getAllByCompStructure(id);
	}
}
