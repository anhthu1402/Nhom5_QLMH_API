package com.qlmh.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.qlmh.api.DTO.FaceDTO;
import com.qlmh.api.DTO.FaceRequestDTO;
import com.qlmh.api.Model.Face;
import com.qlmh.api.Model.Node;
import com.qlmh.api.Service.FaceService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/faces")
public class FaceConroller {
	@Autowired
	FaceService faceService;
	
	// create face
	@RequestMapping(value = "" , method = RequestMethod.POST)
	public Face createFace() {
		return faceService.createFace();
	}
	
	// add node
	@RequestMapping(value = "/{face-id}/nodes", method = RequestMethod.PUT)
	public FaceDTO addNode(@PathVariable(value = "face-id") Integer faceId, @RequestBody Node node) {
		return faceService.addNode(faceId, node);
	}
	

	@RequestMapping(value = "/create" , method = RequestMethod.POST)
	public Face create(@RequestBody FaceRequestDTO nodes) {
		return faceService.create(nodes);
	}
}
