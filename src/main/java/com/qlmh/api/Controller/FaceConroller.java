package com.qlmh.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qlmh.api.DTO.FaceDTO;
import com.qlmh.api.Model.Face;
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
	@RequestMapping(value = "/{face-id}/nodes/{node-id}", method = RequestMethod.PUT)
	public FaceDTO addNode(@PathVariable(value = "face-id") Integer faceId, @PathVariable(value = "node-id") Integer nodeId) {
		return faceService.addNode(faceId, nodeId);
	}
}
