package com.example.demo.entites;

import com.example.domain.services.PlateService;


public class Motorcycle extends Vehicle{

	private static final long serialVersionUID = 1L;

	private PlateService plateService;
	
	
	
	public Motorcycle(String id, String model, String owner, PlateService service) {
		
		super(id, model,null, owner);
		this.plateService = service;
		plateService.generatePlate(this);
		
	}


	

	
	
	
}
