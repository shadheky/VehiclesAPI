package com.example.demo.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.Motorcycle;
import com.example.demo.entites.Owner;
import com.example.demo.entites.Vehicle;
import com.example.domain.services.BrazilPlateService;
import com.example.domain.services.MercosulPlateService;


@RestController
@RequestMapping(value="/vehicles")
public class VehicleResource {
	@GetMapping	
	public ResponseEntity<List<Vehicle>> findAll(){
		Vehicle v1 = new Motorcycle("1","fz25-2019",new Owner("Luiz alberto", "av-7-de-setembro-igarapeaçu-num-4015"),new MercosulPlateService());
		//Vehicle v2 = new Motorcycle("2","fz15-2019",,new BrazilPlateService());
		List<Vehicle> list = Arrays.asList(v1);
		return ResponseEntity.ok().body(list);
		
	}
	
	
}
