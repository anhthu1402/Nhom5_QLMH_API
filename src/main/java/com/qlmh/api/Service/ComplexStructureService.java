package com.qlmh.api.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlmh.api.DTO.ComplexStructureDTO;
import com.qlmh.api.DTO.SimpleStructureResponseDTO;
import com.qlmh.api.Model.ComplexStructure;
import com.qlmh.api.Model.SimpleStructure;
import com.qlmh.api.Repository.ComplexStructureRepository;
import com.qlmh.api.Repository.FloorLevelRepository;

@Service
public class ComplexStructureService {
	@Autowired
	ComplexStructureRepository complexStructureRepository;
	
	@Autowired
	FloorLevelRepository floorLevelRepository;
	
	// create
//	public ComplexStructure create(ComplexStructure complexStructure) {
//		ComplexStructure complexStructure2 = complexStructureRepository.findByName(complexStructure.getName().trim());
//		if(complexStructure2 != null) {
//			return complexStructure2;
//		}
//		return complexStructureRepository.save(complexStructure);
//	}
	
	public ComplexStructure create(ComplexStructureDTO complexStructure) {
		ComplexStructure result = complexStructureRepository.findByName(complexStructure.getName().trim());
		if(result != null && result.getFloorLevel().getId() == complexStructure.getFloorLevelId()) {
			return result;
		}
		
		result = new ComplexStructure();
		result.setName(complexStructure.getName());
		result.setFloorLevel(floorLevelRepository.findById(complexStructure.getFloorLevelId()).get());
		return complexStructureRepository.save(result);
	}
	
	// get all complex structures
	public List<ComplexStructure> getAllComplexStructures(){
		return complexStructureRepository.findAll();
	}
	
	//find all by floorlevel
	public List<ComplexStructure> getAllByFloorID(Integer floorID) {
		List<ComplexStructure> search = complexStructureRepository.findAll();
		List<ComplexStructure> result = new ArrayList<ComplexStructure>();
		
		for (ComplexStructure cs: search) {
			if (cs.getFloorLevel().getId() == floorID) {
				result.add(cs);
			}
		}
		
		return result;
	}
}
