package com.qlmh.api.DTO;

public class SimpleStructureDTO {
	private String name;
	private Double height;
	private String color;
	private Integer faceId;
	private Integer floorLevelId;
	
	public SimpleStructureDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public SimpleStructureDTO(String name, Double height, String color, Integer faceId, Integer floorLevelId) {
		this.name = name;
		this.height = height;
		this.color = color;
		this.faceId = faceId;
		this.floorLevelId = floorLevelId;
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

	public Integer getFaceId() {
		return faceId;
	}

	public void setFaceId(Integer faceId) {
		this.faceId = faceId;
	}

	public Integer getFloorLevelId() {
		return floorLevelId;
	}

	public void setFloorLevelId(Integer floorLevelId) {
		this.floorLevelId = floorLevelId;
	}
}
