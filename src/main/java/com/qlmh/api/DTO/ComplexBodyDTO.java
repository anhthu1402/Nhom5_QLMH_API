package com.qlmh.api.DTO;

import java.util.ArrayList;
import java.util.List;

import com.qlmh.api.Model.ComplexBody;
import com.qlmh.api.Model.ComplexBodyProp;
import com.qlmh.api.Model.ComplexStructure;

public class ComplexBodyDTO {
	private Integer id;
	private String name;
	private ComplexStructure complexStructure;
	private List<ComplexBodyPropDTO> components = new ArrayList<ComplexBodyPropDTO>();
	
	public ComplexBodyDTO(ComplexBody complexBody) {
		id = complexBody.getId();
		name = complexBody.getName();
		complexStructure = complexBody.getComplexStructure();
		List<ComplexBodyProp> list = complexBody.getComponents();
		for (ComplexBodyProp complexBodyProp : list) {
			components.add(new ComplexBodyPropDTO(complexBodyProp));
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

	public List<ComplexBodyPropDTO> getComponents() {
		return components;
	}

	public void setComponents(List<ComplexBodyPropDTO> components) {
		this.components = components;
	}
}
