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
@Table(name = "face")
public class Face {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_face")
	private Integer id;
	
	@JsonIgnore
	@OneToMany(mappedBy = "face")
	private List<FaceNode> faceNodes = new ArrayList<FaceNode>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "face")
	private List<SimpleStructure> simpleStructures = new ArrayList<SimpleStructure>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "face")
	private List<SimpleBody> simpleBodies = new ArrayList<SimpleBody>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "face")
	private List<ComplexBodyFace> complexBodyFaces = new ArrayList<ComplexBodyFace>();
	
	public Face() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<FaceNode> getFaceNodes() {
		return faceNodes;
	}

	public void setFaceNodes(List<FaceNode> faceNodes) {
		this.faceNodes = faceNodes;
	}

	public List<SimpleStructure> getSimpleStructures() {
		return simpleStructures;
	}

	public void setSimpleStructures(List<SimpleStructure> simpleStructures) {
		this.simpleStructures = simpleStructures;
	}

	public List<SimpleBody> getSimpleBodies() {
		return simpleBodies;
	}

	public void setSimpleBodies(List<SimpleBody> simpleBodies) {
		this.simpleBodies = simpleBodies;
	}

	public List<ComplexBodyFace> getComplexBodyFaces() {
		return complexBodyFaces;
	}

	public void setComplexBodyFaces(List<ComplexBodyFace> complexBodyFaces) {
		this.complexBodyFaces = complexBodyFaces;
	}
}
