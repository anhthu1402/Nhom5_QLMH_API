package com.qlmh.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlmh.api.Model.ComplexBodyFace;

@Repository
public interface ComplexBodyFaceRepository extends JpaRepository<ComplexBodyFace, Integer>{
	
}
