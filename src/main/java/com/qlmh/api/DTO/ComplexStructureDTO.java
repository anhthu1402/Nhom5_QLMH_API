package com.qlmh.api.DTO;

public class ComplexStructureDTO {
	private String name;
	private Integer floorLevelId;
	
	public ComplexStructureDTO() {}
	
	public ComplexStructureDTO(String name, Integer floorLevelId) {
		this.name = name;
		this.floorLevelId = floorLevelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFloorLevelId() {
		return floorLevelId;
	}

	public void setFloorLevelId(Integer floorLevelId) {
		this.floorLevelId = floorLevelId;
	}
}
