package com.qlmh.api.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlmh.api.DTO.ComplexBodyDTO;
import com.qlmh.api.Model.ComplexBody;
import com.qlmh.api.Model.ComplexBodyFace;
import com.qlmh.api.Model.ComplexStructure;
import com.qlmh.api.Model.Face;
import com.qlmh.api.Repository.ComplexBodyFaceRepository;
import com.qlmh.api.Repository.ComplexBodyRepository;
import com.qlmh.api.Repository.ComplexStructureRepository;
import com.qlmh.api.Repository.FaceRepository;

@Service
public class ComplexBodyService {
	@Autowired
	ComplexBodyRepository complexBodyRepository;
	
	@Autowired
	ComplexBodyFaceRepository complexBodyFaceRepository;
	
	@Autowired
	FaceRepository faceRepository;
	
	@Autowired
	ComplexStructureRepository complexStructureRepository;
	
	// create complex body 
	public ComplexBody createComplexBody(ComplexBody complexBody) {
		Integer complexStructure = complexBody.getComplexStructure().getId();
		ComplexBody complexBody2 = complexBodyRepository.findByName(complexBody.getName().trim());
		if(complexBody2 != null) {
			if(complexBody2.getComplexStructure().getId() == complexStructure) {
				return complexBody2;
			}
		}
		return complexBodyRepository.save(complexBody);
	}
	
	// get all
	public List<ComplexBody> getAllComplexBodies(){
		return complexBodyRepository.findAll();
	}
	
	// get all by comp strcuture id
	public List<ComplexBody> getAllByCompStructure(Integer id){
		Optional<ComplexStructure> optional = complexStructureRepository.findById(id);
		List<ComplexBody> result = new ArrayList<ComplexBody>();
		if(optional.isPresent()) {
			List<ComplexBody> list = getAllComplexBodies();
			for (ComplexBody complexBody : list) {
				if(complexBody.getComplexStructure().getId() == id) {
					result.add(complexBody);
				}
			}
		}
		if(result.isEmpty()) {
			return null;
		}
		return result;
	}
	
	
	// get by id
	public ComplexBodyDTO getById(Integer id) {
		Optional<ComplexBody> optional = complexBodyRepository.findById(id);
		if(optional.isPresent()) {
			return new ComplexBodyDTO(optional.get());
		}
		return null;
	}
}
