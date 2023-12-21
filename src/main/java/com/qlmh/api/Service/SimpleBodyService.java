package com.qlmh.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlmh.api.DTO.SimpleBodyDTO;
import com.qlmh.api.Model.ComplexStructure;
import com.qlmh.api.Model.Face;
import com.qlmh.api.Model.SimpleBody;
import com.qlmh.api.Repository.FaceRepository;
import com.qlmh.api.Repository.SimpleBodyRepository;

@Service
public class SimpleBodyService {
	@Autowired
	SimpleBodyRepository simpleBodyRepository;
	
	@Autowired
	FaceRepository faceRepository;
	
	// create
	public SimpleBodyDTO create(SimpleBody simpleBody, Integer faceId) {
		Integer complexStructure = simpleBody.getComplexStructure().getId();
		SimpleBody simpleBody2 = simpleBodyRepository.findByName(simpleBody.getName().trim());
		if(simpleBody2 != null) {
			if(simpleBody2.getComplexStructure().getId() == complexStructure) {
				return new SimpleBodyDTO(simpleBody2);
			}
		}
		Face face = faceRepository.findById(faceId).get();
		simpleBody.setFace(face);
		simpleBodyRepository.save(simpleBody);
		return new SimpleBodyDTO(simpleBody);
	}
	
	
}
