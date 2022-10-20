package com.example.demo.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Owner;
import com.example.demo.domain.Vehicle;
import com.example.demo.repository.service.OwnerRepositoryService;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

	
	@Autowired
	OwnerRepositoryService ownerService;
	
	@GetMapping("/{cpf}")
	public Owner getById(@PathVariable("cpf") String cpf) {
		
		return ownerService.findByCpf(cpf);
	}
	
	@GetMapping("/vehicles/{cpf}")
	public List<Vehicle> getVehicles(@PathVariable("cpf") String cpf){
		Owner owner = ownerService.findByCpf(cpf);
		return owner.getVehicles();
		
	}
	
}
