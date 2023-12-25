package com.qlmh.api.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlmh.api.DTO.ComplexBodyPropDTO;
import com.qlmh.api.Model.ComplexBody;
import com.qlmh.api.Model.ComplexBodyFace;
import com.qlmh.api.Model.ComplexBodyProp;
import com.qlmh.api.Model.Face;
import com.qlmh.api.Repository.ComplexBodyFaceRepository;
import com.qlmh.api.Repository.ComplexBodyPropRepository;
import com.qlmh.api.Repository.ComplexBodyRepository;
import com.qlmh.api.Repository.FaceRepository;

@Service
public class ComplexBodyPropService {
	@Autowired
	ComplexBodyPropRepository complexBodyPropRepository;
	
	@Autowired
	FaceRepository faceRepository;
	
	@Autowired
	ComplexBodyFaceRepository complexBodyFaceRepository;
	
	@Autowired 
	ComplexBodyRepository complexBodyRepository;
	
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
	
	// get all by complex body id
	public List<ComplexBodyPropDTO> getAllByCompBodyId(Integer id){
		Optional<ComplexBody> optional = complexBodyRepository.findById(id);
		List<ComplexBodyPropDTO> result = new ArrayList<ComplexBodyPropDTO>(); 
		if(optional.isPresent()) {
			ComplexBody complexBody = optional.get();
			List<ComplexBodyProp> list = complexBody.getComponents();
			for (ComplexBodyProp complexBodyProp : list) {
				result.add(new ComplexBodyPropDTO(complexBodyProp));
			}
		}
		if(result.isEmpty()) {
			return null;
		}
		return result;
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
	
	// delete
	public boolean deleteById(Integer id) {
		Optional<ComplexBodyProp> optional = complexBodyPropRepository.findById(id);
		if(optional.isPresent()) {
			ComplexBodyProp complexBodyProp = optional.get();
			List<ComplexBodyFace> faces = complexBodyProp.getFaces();
			for (ComplexBodyFace complexBodyFace : faces) {
				complexBodyFaceRepository.deleteById(complexBodyFace.getId());
			}
			complexBodyPropRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
