package com.qlmh.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlmh.api.Model.Construction;
import com.qlmh.api.Repository.ConstructionRepository;

@Service
public class ConstructionService {
	@Autowired
	ConstructionRepository constructionRepository;
	
	// create
	public Construction createConstruction(Construction construction) {
		Construction c = constructionRepository.findByName(construction.getName().trim());
		if(c != null) {
			return c;
		}
		return constructionRepository.save(construction);
	}
}
