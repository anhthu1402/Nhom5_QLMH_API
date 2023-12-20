package com.qlmh.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlmh.api.Model.FaceNode;

@Repository
public interface FaceNodeRepository extends JpaRepository<FaceNode, Integer>{

}
