package com.qlmh.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlmh.api.Model.Construction;

@Repository
public interface ConstructionRepository extends JpaRepository<Construction, Integer>{
	public Construction findByName(String name);
}
