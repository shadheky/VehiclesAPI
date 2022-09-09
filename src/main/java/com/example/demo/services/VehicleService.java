package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Vehicle;
import com.example.demo.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository repository;
	
	public List<Vehicle> findAll(){
		return repository.findAll();
	}
	
}
