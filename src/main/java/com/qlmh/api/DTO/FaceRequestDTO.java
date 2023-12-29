package com.qlmh.api.DTO;

import java.util.ArrayList;
import java.util.List;

import com.qlmh.api.Model.Node;

public class FaceRequestDTO {
	private List<Node> nodes = new ArrayList<>();
	
	public FaceRequestDTO() {}
	
	public FaceRequestDTO(List<Node> nodes) {
		this.nodes = nodes;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	
}
