package com.qlmh.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlmh.api.Model.ComplexBodyProp;

@Repository
public interface ComplexBodyPropRepository extends JpaRepository<ComplexBodyProp, Integer>{
	public ComplexBodyProp findByName(String name);
}
