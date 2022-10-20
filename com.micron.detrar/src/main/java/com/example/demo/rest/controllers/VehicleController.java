package com.example.demo.rest.controllers;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Vehicle;
import com.example.demo.domain.dto.PlateDTO;
import com.example.demo.domain.dto.VehiclePostDTO;
import com.example.demo.repository.service.VehicleRepositoryService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

	
	@Autowired
	private VehicleRepositoryService service;
	
	@GetMapping
	public List<Vehicle> getAll() {	
		return service.findAll();
	}
	
	@GetMapping("/{plateValue}")
	public Vehicle getByPlate(@PathVariable String plateValue) {
		return service.findByPlate(plateValue);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vehicle postVehicle(@RequestBody @Valid VehiclePostDTO vehicle) throws ParseException {
		return service.save(vehicle);
		
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateVehiclePlate(@RequestBody PlateDTO plate, @PathVariable("id") String plateValue) {
		service.updatePlate(plate, plateValue);
	}
	
}
