package com.qlmh.api.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "simple_body")
public class SimpleBody {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_simple_body")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "height")
	private Double height;
	
	@Column(name = "color")
	private String color;
	
	@ManyToOne
	@JoinColumn(name = "id_face")
	private Face face;
	
	@ManyToOne
	@JoinColumn(name = "id_complex_structure")
	private ComplexStructure complexStructure;
	
	public SimpleBody() {
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

	public Face getFace() {
		return face;
	}

	public void setFace(Face face) {
		this.face = face;
	}

	public ComplexStructure getComplexStructure() {
		return complexStructure;
	}

	public void setComplexStructure(ComplexStructure complexStructure) {
		this.complexStructure = complexStructure;
	}
	
}
