package com.qlmh.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlmh.api.Model.Face;

@Repository
public interface FaceRepository extends JpaRepository<Face, Integer>{

}
