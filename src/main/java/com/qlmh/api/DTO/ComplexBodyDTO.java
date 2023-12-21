package com.qlmh.api.DTO;

import java.util.ArrayList;
import java.util.List;

import com.qlmh.api.Model.ComplexBody;
import com.qlmh.api.Model.ComplexBodyFace;
import com.qlmh.api.Model.ComplexStructure;

public class ComplexBodyDTO {
	private Integer id;
	private String name;
	private ComplexStructure complexStructure;
	private List<ComplexBodyFaceDTO> components = new ArrayList<ComplexBodyFaceDTO>();
	
	public ComplexBodyDTO(ComplexBody complexBody) {
		id = complexBody.getId();
		name = complexBody.getName();
		complexStructure = complexBody.getComplexStructure();
		List<ComplexBodyFace> list = complexBody.getComponents();
		for (ComplexBodyFace complexBodyFace : list) {
			components.add(new ComplexBodyFaceDTO(complexBodyFace));
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

	public ComplexStructure getComplexStructure() {
		return complexStructure;
	}

	public void setComplexStructure(ComplexStructure complexStructure) {
		this.complexStructure = complexStructure;
	}

	public List<ComplexBodyFaceDTO> getComponents() {
		return components;
	}

	public void setComponents(List<ComplexBodyFaceDTO> components) {
		this.components = components;
	}
}
