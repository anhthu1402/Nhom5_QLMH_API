package com.qlmh.api.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "node")
public class Node {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_node")
	private Integer id;
	
	@Column(name = "x")
	private Double x;
	
	@Column(name = "y")
	private Double y;
	
	@Column(name = "z")
	private Double z;
	
	@JsonIgnore
	@OneToMany(mappedBy = "node")
	private List<FaceNode> faceNode = new ArrayList<FaceNode>();
	
	public Node() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Double getZ() {
		return z;
	}

	public void setZ(Double z) {
		this.z = z;
	}

	public List<FaceNode> getFaceNode() {
		return faceNode;
	}

	public void setFaceNode(List<FaceNode> faceNode) {
		this.faceNode = faceNode;
	}
}
