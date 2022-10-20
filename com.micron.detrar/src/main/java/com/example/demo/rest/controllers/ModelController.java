package com.example.demo.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Model;
import com.example.demo.domain.dto.ModelDTO;
import com.example.demo.repository.service.ModelRepositoryService;

@RestController
@RequestMapping(value="/api/models")
public class ModelController {

	@Autowired
	private ModelRepositoryService service;
	
	@GetMapping(value="/{name}")
	public List<Model> findAllByName(@PathVariable("name") String name){
		return service.findByName(name);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Model saveModel(@RequestBody ModelDTO model){	
		return service.save(model);
	}
	
}
