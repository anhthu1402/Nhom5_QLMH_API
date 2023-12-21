package com.qlmh.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlmh.api.DTO.ComplexBodyDTO;
import com.qlmh.api.DTO.ComplexBodyFaceDTO;
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
	
	// add component(complex body face)
	public ComplexBodyDTO addComponent(Integer compBodyId, ComplexBodyFace complexBodyFace, Integer faceId) {
		ComplexBody complexBody = complexBodyRepository.findById(compBodyId).get();
		Face face = faceRepository.findById(faceId).get();
		ComplexBodyFace complexBodyFace2 = complexBodyFaceRepository.findByName(complexBodyFace.getName().trim());
		if(complexBodyFace2 != null) {
			ComplexBody complexBody2 = complexBodyFace2.getComplexBody();
			if(complexBody2.getId() == compBodyId) {
				return new ComplexBodyDTO(complexBody2);
			}
		}
		complexBodyFace.setFace(face);
		complexBodyFace.setComplexBody(complexBody);
		complexBodyFaceRepository.save(complexBodyFace);
		return new ComplexBodyDTO(complexBody);
	}
}
