package com.qlmh.api.DTO;

import com.qlmh.api.Model.*;

public class SimpleStructureResponseDTO {
	private Integer id;
	private String name;
	private Double height;
	private String color;
	private FaceDTO face;
	private FloorLevel floorLevel;
	
	public SimpleStructureResponseDTO(SimpleStructure simpleStructure) {
		id = simpleStructure.getId();
		name = simpleStructure.getName();
		height = simpleStructure.getHeight();
		color = simpleStructure.getColor();
		face = new FaceDTO(simpleStructure.getFace());
		floorLevel = simpleStructure.getFloorLevel();
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

	public FaceDTO getFace() {
		return face;
	}

	public void setFace(FaceDTO face) {
		this.face = face;
	}

	public FloorLevel getFloorLevel() {
		return floorLevel;
	}

	public void setFloorLevel(FloorLevel floorLevel) {
		this.floorLevel = floorLevel;
	}
}
