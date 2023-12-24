package com.qlmh.api.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlmh.api.DTO.*;
import com.qlmh.api.Model.*;
import com.qlmh.api.Repository.*;

@Service
public class SimpleStructureService {
	@Autowired
	SimpleStructureRepository simpleStructureRepository;
	
	@Autowired
	FaceRepository faceRepository;
	
	@Autowired
	FloorLevelRepository floorLevelRepository;
	
	// create
	public SimpleStructure create(SimpleStructureDTO simpleStructure) {
		SimpleStructure search = simpleStructureRepository.findByName(simpleStructure.getName().trim());
		
		if (search == null) {
			Face face = faceRepository.findById(simpleStructure.getFaceId()).get();
			FloorLevel floor = floorLevelRepository.findById(simpleStructure.getFloorLevelId()).get();
			
			if (face != null && floor != null) {
				SimpleStructure result = new SimpleStructure();
				result.setName(simpleStructure.getName());
				result.setHeight(simpleStructure.getHeight());
				result.setColor(simpleStructure.getColor());
				result.setFace(face);
				result.setFloorLevel(floor);
				
				simpleStructureRepository.save(result);
				return result;
			} else {
				return null;
			}
		}
		return null;
	}
	
	//read all
	public List<SimpleStructureResponseDTO> getAll() {
		List<SimpleStructureResponseDTO> result = new ArrayList<SimpleStructureResponseDTO>();
		List<SimpleStructure> listStructures = simpleStructureRepository.findAll();
		
		for (SimpleStructure s: listStructures) {
			result.add(new SimpleStructureResponseDTO(s));
		}
		
		return result;
	}
	
	//read by id
	public SimpleStructureResponseDTO getById(Integer id) {
		Optional<SimpleStructure> result = simpleStructureRepository.findById(id);
		
		if (result.isPresent()) {
			return new SimpleStructureResponseDTO(result.get());
		}
		return null;
	}
	
	//find all by floorlevel
	public List<SimpleStructureResponseDTO> getAllByFloorID(Integer floorID) {
		List<SimpleStructure> search = simpleStructureRepository.findAll();
		List<SimpleStructureResponseDTO> result = new ArrayList<SimpleStructureResponseDTO>();
		
		for (SimpleStructure ss: search) {
			if (ss.getFloorLevel().getId() == floorID) {
				result.add(new SimpleStructureResponseDTO(ss));
			}
		}
		
		return result;
	}
	
	//delete
	public void delete(Integer id) {
		Optional<SimpleStructure> result = simpleStructureRepository.findById(id);
		if (result.isPresent()) {
			simpleStructureRepository.delete(result.get());
		}
	}
}
