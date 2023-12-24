package com.qlmh.api.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlmh.api.Exception.*;
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
		SimpleStructure search = simpleStructureRepository.findByName(simpleStructure.getName());
		
		if (search != null) {
			Face face = faceRepository.findById(simpleStructure.getFaceId()).get();
			FloorLevel floor = floorLevelRepository.findById(simpleStructure.getFloorLevelId()).get();
			
			if (face != null && floor != null) {
				SimpleStructure result = new SimpleStructure();
				result.setName(simpleStructure.getName());
				result.setHeight(simpleStructure.getHeight());
				result.setColor(simpleStructure.getColor());
				result.setFace(face);
				result.setFloorLevel(floor);
				
				return simpleStructureRepository.save(result);
			} else {
				throw new CustomValidationException("Không tìm thấy face hoặc floor level tương ứng!");
			}
		} else {
			throw new CustomValidationException("Tên của kiến trúc đơn giản " + simpleStructure.getName() + " đã tồn tại!");
		}
	}
	
	//read all
	public List<SimpleStructure> getAllSimpleStructure() {
		return simpleStructureRepository.findAll();
	}
	
	//read by id
	public SimpleStructure getSimpleStructureById(Integer id) {
		SimpleStructure result = simpleStructureRepository.findById(id).get();
		
		if (result != null) {
			return result;
		} else {
			throw new CustomValidationException("Không tồn tại kiến trúc đơn giản có ID = " + id);
		}
	}
	
	//find all by floorlevel
	public List<SimpleStructure> findAllSimpleStructureByFloorLevel(Integer floorID) {
		List<SimpleStructure> search = simpleStructureRepository.findAll();
		List<SimpleStructure> result = new ArrayList<SimpleStructure>();
		
		for (SimpleStructure ss: search) {
			if (ss.getFloorLevel().getId() == floorID) {
				result.add(ss);
			}
		}
		
		return result;
	}
	
	//delete
	public void deleteSimpleStructure(Integer id) {
		Optional<SimpleStructure> result = simpleStructureRepository.findById(id);
		if (result.isPresent())
			simpleStructureRepository.delete(result.get());
		else throw new CustomValidationException("Không tồn tại kiến trúc đơn giản có ID = " + id);
	}
}
