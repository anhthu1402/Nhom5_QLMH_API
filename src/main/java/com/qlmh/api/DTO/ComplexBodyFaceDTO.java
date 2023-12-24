package com.qlmh.api.DTO;
import com.qlmh.api.Model.ComplexBodyFace;

public class ComplexBodyFaceDTO {
	private Integer id;
	private FaceDTO face;
	
	public ComplexBodyFaceDTO(ComplexBodyFace complexBodyFace) {
		id = complexBodyFace.getId();
		face = new FaceDTO(complexBodyFace.getFace());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FaceDTO getFace() {
		return face;
	}

	public void setFace(FaceDTO face) {
		this.face = face;
	}
}
