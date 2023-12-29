package com.qlmh.api.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlmh.api.DTO.*;
import com.qlmh.api.Model.*;
import com.qlmh.api.Repository.*;

@Service
public class FaceService {
	@Autowired
	FaceRepository faceRepository;
	
	@Autowired
	FaceNodeRepository faceNodeRepository;
	
	@Autowired
	NodeRepository nodeRepository;
	
	@Autowired
	NodeService nodeService;
	
	// create face
	public Face createFace() {
		return faceRepository.save(new Face());
	}
	
	public Face create(FaceRequestDTO nodes) {
		Face face = faceRepository.save(new Face());

		for (Node n: nodes.getNodes()) {
			faceNodeRepository.save(new FaceNode(face, nodeService.createNode(n)));
		}
		
		return face;
	}
	
	// add node
	public FaceDTO addNode(Integer faceId, Node node) {
		Node n = nodeService.createNode(node);
		Face face = faceRepository.findById(faceId).get();
		
		List<FaceNode> faceNodes = faceNodeRepository.findAll();
		for (FaceNode faceNode : faceNodes) {
			Face f = faceNode.getFace();
			if(f.getId() == faceId) {
				if(faceNode.getNode().getId() == n.getId()) {
					return new FaceDTO(f);
				}
			}
		}
		
		FaceNode faceNode = new FaceNode(face, n);
		faceNodeRepository.save(faceNode);

		return new FaceDTO(face);
	}
}
