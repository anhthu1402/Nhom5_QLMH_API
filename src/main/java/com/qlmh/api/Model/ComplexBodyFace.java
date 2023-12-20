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
@Table(name = "complex_body_face")
public class ComplexBodyFace {
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
	@JoinColumn(name = "id_face")
	private Face face;
	
	@ManyToOne
	@JoinColumn(name = "id_complex_body")
	private ComplexBody complexBody;
	
	public ComplexBodyFace() {
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

	public ComplexBody getComplexBody() {
		return complexBody;
	}

	public void setComplexBody(ComplexBody complexBody) {
		this.complexBody = complexBody;
	}
}
