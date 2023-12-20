package com.qlmh.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qlmh.api.Model.Node;
import com.qlmh.api.Service.NodeService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/nodes")
public class NodeController {
	@Autowired
	NodeService nodeService;
	
	// create node
	@RequestMapping(value = "" , method = RequestMethod.POST)
	public Node createNode(@RequestBody Node node) {
		return nodeService.createNode(node);
	}
}
