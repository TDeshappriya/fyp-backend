package com.example.demo.superController;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Data;


public interface superController extends CrudRepository<Data, Integer> {

	
//	@Query(value = "SELECT id FROM data where iri_value = 123", nativeQuery = true)
//	public List<Data> sample();
}
