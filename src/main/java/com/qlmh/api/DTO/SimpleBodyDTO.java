package com.qlmh.api.DTO;

import com.qlmh.api.Model.ComplexStructure;
import com.qlmh.api.Model.SimpleBody;

public class SimpleBodyDTO {
	private Integer id;
	private String name;
	private Double height;
	private String color;
	private ComplexStructure complexStructure;
	private FaceDTO face;
	
	public SimpleBodyDTO(SimpleBody simpleBody) {
		id = simpleBody.getId();
		name = simpleBody.getName();
		height = simpleBody.getHeight();
		color = simpleBody.getColor();
		complexStructure = simpleBody.getComplexStructure();
		face = new FaceDTO(simpleBody.getFace());
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

	public ComplexStructure getComplexStructure() {
		return complexStructure;
	}

	public void setComplexStructure(ComplexStructure complexStructure) {
		this.complexStructure = complexStructure;
	}

	public FaceDTO getFace() {
		return face;
	}

	public void setFace(FaceDTO face) {
		this.face = face;
	}
	
}
