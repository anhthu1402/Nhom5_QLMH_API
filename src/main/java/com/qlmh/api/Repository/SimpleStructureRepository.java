package com.qlmh.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlmh.api.Model.SimpleStructure;

@Repository
public interface SimpleStructureRepository extends JpaRepository<SimpleStructure, Integer>{

}
