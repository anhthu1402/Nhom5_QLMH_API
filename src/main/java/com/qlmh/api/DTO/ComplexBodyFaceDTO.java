package com.qlmh.api.DTO;
import com.qlmh.api.Model.ComplexBodyFace;

public class ComplexBodyFaceDTO {
	private Integer id;
	private String name;
	private Double height;
	private String color;
	private FaceDTO face;
	
	public ComplexBodyFaceDTO(ComplexBodyFace complexBodyFace) {
		id = complexBodyFace.getId();
		name = complexBodyFace.getName();
		height = complexBodyFace.getHeight();
		color = complexBodyFace.getColor();
		face = new FaceDTO(complexBodyFace.getFace());
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
}
