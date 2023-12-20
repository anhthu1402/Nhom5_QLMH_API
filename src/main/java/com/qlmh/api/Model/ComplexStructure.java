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
@Table(name = "complex_structure")
public class ComplexStructure {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_complex_structure")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "id_floorlevel")
	private FloorLevel floorLevel;
	
	@JsonIgnore
	@OneToMany(mappedBy = "complexStructure")
	private List<SimpleBody> simpleBodies = new ArrayList<SimpleBody>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "complexStructure")
	private List<ComplexBody> complexBodies = new ArrayList<ComplexBody>();
	
	public ComplexStructure() {
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
	public FloorLevel getFloorLevel() {
		return floorLevel;
	}
	public void setFloorLevel(FloorLevel floorLevel) {
		this.floorLevel = floorLevel;
	}
	public List<SimpleBody> getSimpleBodies() {
		return simpleBodies;
	}
	public void setSimpleBodies(List<SimpleBody> simpleBodies) {
		this.simpleBodies = simpleBodies;
	}
	public List<ComplexBody> getComplexBodies() {
		return complexBodies;
	}
	public void setComplexBodies(List<ComplexBody> complexBodies) {
		this.complexBodies = complexBodies;
	}
}
