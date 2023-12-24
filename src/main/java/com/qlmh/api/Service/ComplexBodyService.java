package com.qlmh.api.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlmh.api.DTO.ComplexBodyDTO;
import com.qlmh.api.Model.ComplexBody;
import com.qlmh.api.Model.ComplexBodyFace;
import com.qlmh.api.Model.Face;
import com.qlmh.api.Repository.ComplexBodyFaceRepository;
import com.qlmh.api.Repository.ComplexBodyRepository;
import com.qlmh.api.Repository.FaceRepository;

@Service
public class ComplexBodyService {
	@Autowired
	ComplexBodyRepository complexBodyRepository;
	
	@Autowired
	ComplexBodyFaceRepository complexBodyFaceRepository;
	
	@Autowired
	FaceRepository faceRepository;
	
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
	
	// get by id
	public ComplexBodyDTO getById(Integer id) {
		Optional<ComplexBody> optional = complexBodyRepository.findById(id);
		if(optional.isPresent()) {
			return new ComplexBodyDTO(optional.get());
		}
		return null;
	}
}
