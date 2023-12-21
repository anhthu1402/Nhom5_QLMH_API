package com.qlmh.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlmh.api.Model.ComplexStructure;

@Repository
public interface ComplexStructureRepository extends JpaRepository<ComplexStructure, Integer>{
	public ComplexStructure findByName(String name);
}
