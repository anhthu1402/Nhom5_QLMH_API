package com.qlmh.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlmh.api.Model.ComplexBody;

@Repository
public interface ComplexBodyRepository extends JpaRepository<ComplexBody, Integer>{
	public ComplexBody findByName(String name);
}
