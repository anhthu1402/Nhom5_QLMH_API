package com.qlmh.api.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlmh.api.Model.Node;

@Repository
public interface NodeRepository extends JpaRepository<Node, Integer>{
	public Optional<Node> findByXAndYAndZ(Double x, Double y, Double z);
}
