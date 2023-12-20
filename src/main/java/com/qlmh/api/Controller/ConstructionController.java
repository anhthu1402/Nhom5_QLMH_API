package com.qlmh.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qlmh.api.Model.Construction;
import com.qlmh.api.Service.ConstructionService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/constructions")
public class ConstructionController {

	@Autowired
	ConstructionService constructionService;
	
	// create
	@RequestMapping(value = "" , method = RequestMethod.POST)
	public Construction createConstruction (@RequestBody Construction construction) {
		return constructionService.createConstruction(construction);
	}
}
