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
@Table(name = "floor_level")
public class FloorLevel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_floorlevel")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_construction")
	private Construction construction;
	
	@JsonIgnore
	@OneToMany(mappedBy = "floorLevel")
	private List<SimpleStructure> simpleStructures = new ArrayList<SimpleStructure>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "floorLevel")
	private List<ComplexStructure> complexStructures = new ArrayList<ComplexStructure>();
	
	public FloorLevel() {
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

	public Construction getConstruction() {
		return construction;
	}

	public void setConstruction(Construction construction) {
		this.construction = construction;
	}

	public List<SimpleStructure> getSimpleStructures() {
		return simpleStructures;
	}

	public void setSimpleStructures(List<SimpleStructure> simpleStructures) {
		this.simpleStructures = simpleStructures;
	}

	public List<ComplexStructure> getComplexStructures() {
		return complexStructures;
	}

	public void setComplexStructures(List<ComplexStructure> complexStructures) {
		this.complexStructures = complexStructures;
	}
}
