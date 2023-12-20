package com.qlmh.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qlmh.api.Model.SimpleBody;

@Repository
public interface SimpleBodyRepository extends JpaRepository<SimpleBody, Integer>{

}
