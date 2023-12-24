package com.qlmh.api.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "complex_body_face")
public class ComplexBodyFace {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_face")
	private Face face;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_complex_body_prop")
	private ComplexBodyProp complexBodyProp;
	
	public ComplexBodyFace() {
		// TODO Auto-generated constructor stub
	}
	
	public ComplexBodyFace(ComplexBodyProp complexBodyProp, Face face) {
		this.face = face;
		this.complexBodyProp = complexBodyProp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ComplexBodyProp getComplexBodyProp() {
		return complexBodyProp;
	}

	public void setComplexBodyProp(ComplexBodyProp complexBodyProp) {
		this.complexBodyProp = complexBodyProp;
	}

	public Face getFace() {
		return face;
	}

	public void setFace(Face face) {
		this.face = face;
	}

}
