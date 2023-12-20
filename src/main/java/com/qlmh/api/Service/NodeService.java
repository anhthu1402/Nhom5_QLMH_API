package com.qlmh.api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlmh.api.Model.Node;
import com.qlmh.api.Repository.NodeRepository;

@Service
public class NodeService {
	@Autowired
	NodeRepository nodeRepository;
	
	// create node
	public Node createNode(Node n) {
		List<Node> list = nodeRepository.findAll();
		for (Node node : list) {
			if(Double.compare(node.getX(), n.getX()) == 0 && Double.compare(node.getY(), n.getY()) == 0 && Double.compare(node.getZ(), n.getZ()) == 0) {
				return node;
			}
		}
		return nodeRepository.save(n);
	}
	
	public List<Node> gellAllNodes(){
		return nodeRepository.findAll();
	}
		
}
