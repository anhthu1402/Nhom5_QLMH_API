package com.qlmh.api.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "complex_body")
public class ComplexBody {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_complexbody")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "id_complex_structure")
	private ComplexStructure complexStructure;
	
	@JsonIgnore
	@OneToMany(mappedBy = "complexBody")
	private List<ComplexBodyProp> components = new ArrayList<ComplexBodyProp>();
	
	public ComplexBody() {
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

	public ComplexStructure getComplexStructure() {
		return complexStructure;
	}

	public void setComplexStructure(ComplexStructure complexStructure) {
		this.complexStructure = complexStructure;
	}

	public List<ComplexBodyProp> getComponents() {
		return components;
	}

	public void setComponents(List<ComplexBodyProp> components) {
		this.components = components;
	}
}
