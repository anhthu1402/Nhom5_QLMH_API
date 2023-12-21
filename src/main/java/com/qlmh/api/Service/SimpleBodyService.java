package com.qlmh.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlmh.api.Model.SimpleBody;
import com.qlmh.api.Repository.SimpleBodyRepository;

@Service
public class SimpleBodyService {
	@Autowired
	SimpleBodyRepository simpleBodyRepository;
	
	// create
//	public SimpleBody create(SimpleBody simpleBody) {
//		
//	}
}
