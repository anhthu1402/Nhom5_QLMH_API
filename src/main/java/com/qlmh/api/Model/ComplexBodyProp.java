package com.qlmh.api.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "complex_body_prop")
public class ComplexBodyProp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "height")
	private Double height;
	
	@Column(name = "color")
	private String color;
	
	@ManyToOne
	@JoinColumn(name = "id_complex_body")
	private ComplexBody complexBody;
	
	@JsonIgnore
	@OneToMany(mappedBy = "complexBodyProp")
	private List<ComplexBodyFace> faces = new ArrayList<ComplexBodyFace>();
	
	public ComplexBodyProp() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public ComplexBody getComplexBody() {
		return complexBody;
	}

	public void setComplexBody(ComplexBody complexBody) {
		this.complexBody = complexBody;
	}

	public List<ComplexBodyFace> getFaces() {
		return faces;
	}

	public void setFaces(List<ComplexBodyFace> faces) {
		this.faces = faces;
	}
	public void addFace(ComplexBodyFace bodyFace) {
		this.faces.add(bodyFace);
	}
}
