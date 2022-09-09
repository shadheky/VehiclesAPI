package com.example.demo.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.Motorcycle;
import com.example.demo.entites.Vehicle;
import com.example.domain.services.BrazilPlateService;
import com.example.domain.services.MercosulPlateService;


@RestController
@RequestMapping(value="/vehicles")
public class VehicleResource {
	@GetMapping	
	public ResponseEntity<List<Vehicle>> findAll(){
		Vehicle v1 = new Motorcycle("1","fz25-2019","Marcos Ribeiro",new MercosulPlateService());
		Vehicle v2 = new Motorcycle("2","fz15-2019","Luiz Alberto",new BrazilPlateService());
		List<Vehicle> list = Arrays.asList(v1,v2);
		return ResponseEntity.ok().body(list);
		
	}
	
	
}
