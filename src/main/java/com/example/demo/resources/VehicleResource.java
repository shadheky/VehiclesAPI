package com.example.demo.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.Vehicle;

@RestController
@RequestMapping(value="/vehicles")
public class VehicleResource {
	@GetMapping	
	public ResponseEntity<List<Vehicle>> findAll(){
		Vehicle v1 = new Vehicle("1","civc-honda-2015","QEZ1234","Marcos Ribeiro");
		Vehicle v2 = new Vehicle("2","prisma-chevrolet-2019","QEZ4321","Marcela alves de Souza");
		List<Vehicle> list = Arrays.asList(v1,v2);
		return ResponseEntity.ok().body(list);
		
	}
	
	
}
