package com.qlmh.api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlmh.api.Model.ComplexStructure;
import com.qlmh.api.Repository.ComplexStructureRepository;

@Service
public class ComplexStructureService {
	@Autowired
	ComplexStructureRepository complexStructureRepository;
	
	// create
	public ComplexStructure create(ComplexStructure complexStructure) {
		ComplexStructure complexStructure2 = complexStructureRepository.findByName(complexStructure.getName().trim());
		if(complexStructure2 != null) {
			return complexStructure2;
		}
		return complexStructureRepository.save(complexStructure);
	}
	
	// get all complex structures
	public List<ComplexStructure> getAllComplexStructures(){
		return complexStructureRepository.findAll();
	}
	
	
}
