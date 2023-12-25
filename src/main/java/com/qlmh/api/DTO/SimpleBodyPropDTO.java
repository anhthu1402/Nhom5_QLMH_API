package com.qlmh.api.DTO;

import com.qlmh.api.Model.SimpleBody;

public class SimpleBodyPropDTO {
	private Integer id;
	private String name;
	private Double height;
	private String color;
	
	public SimpleBodyPropDTO(SimpleBody simpleBody) {
		id = simpleBody.getId();
		name = simpleBody.getName();
		height = simpleBody.getHeight();
		color = simpleBody.getColor();
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
}
