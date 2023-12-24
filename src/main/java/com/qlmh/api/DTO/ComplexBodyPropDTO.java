package com.qlmh.api.DTO;

import java.util.ArrayList;
import java.util.List;

import com.qlmh.api.Model.ComplexBody;
import com.qlmh.api.Model.ComplexBodyFace;
import com.qlmh.api.Model.ComplexBodyProp;

public class ComplexBodyPropDTO {
	private Integer id;
	private String name;
	private Double height;
	private String color;
	private List<ComplexBodyFaceDTO> faces = new ArrayList<ComplexBodyFaceDTO>();
	
	public ComplexBodyPropDTO(ComplexBodyProp complexBodyProp) {
		id = complexBodyProp.getId();
		name = complexBodyProp.getName();
		color = complexBodyProp.getColor();
		height = complexBodyProp.getHeight();
		List<ComplexBodyFace> list = complexBodyProp.getFaces();
		for (ComplexBodyFace complexBodyFace : list) {
			faces.add(new ComplexBodyFaceDTO(complexBodyFace));
		}
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

	public List<ComplexBodyFaceDTO> getFaces() {
		return faces;
	}

	public void setFaces(List<ComplexBodyFaceDTO> faces) {
		this.faces = faces;
	}
}
