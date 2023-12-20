package com.qlmh.api.DTO;

import java.util.ArrayList;
import java.util.List;

import com.qlmh.api.Model.Face;
import com.qlmh.api.Model.FaceNode;
import com.qlmh.api.Model.Node;

public class FaceDTO {
	private Integer id;
	private List<Node> nodes = new ArrayList<Node>();
	
	public FaceDTO(Face face) {
		id = face.getId();
		List<FaceNode> faceNodes = face.getFaceNodes();
		for (FaceNode faceNode : faceNodes) {
			nodes.add(faceNode.getNode());
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	
}
