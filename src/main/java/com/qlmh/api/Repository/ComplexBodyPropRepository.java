package com.qlmh.api.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qlmh.api.Model.ComplexBodyProp;

@Repository
public interface ComplexBodyPropRepository extends JpaRepository<ComplexBodyProp, Integer>{
	public ComplexBodyProp findByName(String name);
	
	@Query(value = "SELECT * FROM complex_body_prop WHERE id_complex_body = :id", nativeQuery = true)
    List<ComplexBodyProp> findByIdComplexBody(Integer id);
}
