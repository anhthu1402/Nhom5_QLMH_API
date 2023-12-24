package com.qlmh.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qlmh.api.DTO.ComplexBodyDTO;
import com.qlmh.api.Model.ComplexBody;
import com.qlmh.api.Model.ComplexBodyFace;
import com.qlmh.api.Service.ComplexBodyService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/comp-bodies")
public class ComplexBodyController {
	@Autowired
	ComplexBodyService complexBodyService;
	
	// create complex body
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ComplexBody createComplexBody(@RequestBody ComplexBody complexBody) {
		return complexBodyService.createComplexBody(complexBody);
	}
	
	// get all
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<ComplexBody> getAllComplexBodies(){
		return complexBodyService.getAllComplexBodies();
	}
	
	// get by id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ComplexBodyDTO getById(@PathVariable(value = "id") Integer id) {
		return complexBodyService.getById(id);
	}
}
