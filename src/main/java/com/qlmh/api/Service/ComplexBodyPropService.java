package com.qlmh.api.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlmh.api.DTO.ComplexBodyPropDTO;
import com.qlmh.api.Model.ComplexBodyFace;
import com.qlmh.api.Model.ComplexBodyProp;
import com.qlmh.api.Model.Face;
import com.qlmh.api.Repository.ComplexBodyFaceRepository;
import com.qlmh.api.Repository.ComplexBodyPropRepository;
import com.qlmh.api.Repository.FaceRepository;

@Service
public class ComplexBodyPropService {
	@Autowired
	ComplexBodyPropRepository complexBodyPropRepository;
	
	@Autowired
	FaceRepository faceRepository;
	
	@Autowired
	ComplexBodyFaceRepository complexBodyFaceRepository;
	
	// create
	public ComplexBodyProp create(ComplexBodyProp complexBodyProp) {
		ComplexBodyProp bodyProp = complexBodyPropRepository.findByName(complexBodyProp.getName().trim());
		if(bodyProp != null) {
			if(bodyProp.getComplexBody().getId() == complexBodyProp.getComplexBody().getId()) {
				return bodyProp;
			}
		}
		return complexBodyPropRepository.save(complexBodyProp);
	}
	
	// get all complex body props
	public List<ComplexBodyProp> getAllComplexBodyProps(){
		return complexBodyPropRepository.findAll();
	}
	
	// get by id
	public ComplexBodyPropDTO getById(Integer id) {
		Optional<ComplexBodyProp> optional = complexBodyPropRepository.findById(id);
		if(optional.isPresent()) {
			return new ComplexBodyPropDTO(optional.get());
		}
		return null;
	}
	
	// add face
	public ComplexBodyPropDTO addFace(Integer compBodyPropId, Integer faceId) {
		ComplexBodyProp complexBodyProp = complexBodyPropRepository.findById(compBodyPropId).get();
		Face face = faceRepository.findById(faceId).get();
		
		List<ComplexBodyFace> list = complexBodyProp.getFaces();
		for (ComplexBodyFace complexBodyFace : list) {
			if(complexBodyFace.getFace().getId() == faceId) {
				return new ComplexBodyPropDTO(complexBodyProp);
			}
		}
		
		ComplexBodyFace bodyFace = new ComplexBodyFace(complexBodyProp, face);
		complexBodyFaceRepository.save(bodyFace);
		complexBodyProp.addFace(bodyFace);
		complexBodyPropRepository.save(complexBodyProp);
		return new ComplexBodyPropDTO(complexBodyProp);
	}
}
