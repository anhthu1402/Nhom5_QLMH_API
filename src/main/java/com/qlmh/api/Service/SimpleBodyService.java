package com.qlmh.api.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlmh.api.DTO.SimpleBodyDTO;
import com.qlmh.api.DTO.SimpleBodyPropDTO;
import com.qlmh.api.Model.ComplexStructure;
import com.qlmh.api.Model.Face;
import com.qlmh.api.Model.SimpleBody;
import com.qlmh.api.Repository.ComplexStructureRepository;
import com.qlmh.api.Repository.FaceRepository;
import com.qlmh.api.Repository.SimpleBodyRepository;

@Service
public class SimpleBodyService {
	@Autowired
	SimpleBodyRepository simpleBodyRepository;
	
	@Autowired
	FaceRepository faceRepository;
	
	@Autowired
	ComplexStructureRepository complexStructureRepository;
	
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
	
	// get all
	public List<SimpleBody> getAllSimpleBodies(){
		return simpleBodyRepository.findAll();
	}
	
	// get by id
	public SimpleBodyDTO getById(Integer id) {
		Optional<SimpleBody> optional = simpleBodyRepository.findById(id);
		if(optional.isPresent()) {
			return new SimpleBodyDTO(optional.get());
		}
		return null;
	}
	
	// get all by complex structure id
	public List<SimpleBodyPropDTO> getAllByCompStructure(Integer id){
		Optional<ComplexStructure> optional = complexStructureRepository.findById(id);
		List<SimpleBodyPropDTO> result = new ArrayList<SimpleBodyPropDTO>();
		if(optional.isPresent()) {
			List<SimpleBody> list = getAllSimpleBodies();
			for (SimpleBody simpleBody : list) {
				if(simpleBody.getComplexStructure().getId() == id) {
					result.add(new SimpleBodyPropDTO(simpleBody));
				}
			}
		}
		if(result.isEmpty()) {
			return null;
		}
		return result;
	}
	
	// delete 
	public boolean deleteById(Integer id) {
		Optional<SimpleBody> optional = simpleBodyRepository.findById(id);
		if(optional.isPresent()) {
			simpleBodyRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
