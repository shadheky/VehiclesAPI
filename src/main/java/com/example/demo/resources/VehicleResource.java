package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.Vehicle;
import com.example.demo.services.VehicleService;


@RestController
@RequestMapping(value="/vehicles")
public class VehicleResource {
	@Autowired
	private VehicleService service;
	
	@GetMapping	
	public ResponseEntity<List<Vehicle>> findAll(){
		
		return ResponseEntity.ok().body(service.findAll());
		
	}
	
	
}
