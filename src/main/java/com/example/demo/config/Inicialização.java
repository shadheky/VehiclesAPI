package com.example.demo.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entites.Owner;
import com.example.demo.entites.Vehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.domain.services.MercosulPlateService;

@Configuration
public class Inicialização implements CommandLineRunner{

	@Autowired
	private VehicleRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();
		
		Vehicle v1 = new Vehicle(null,"fz25-2019",new MercosulPlateService().generatePlate(),new Owner("Luiz alberto", "av-7-de-setembro-igarapeaçu-num-4015"));
		//Vehicle v2 = new Motorcycle(null,"fz15-2019",new Owner("Marcos Ribeiro", "av-Rodolfo-Chermont-Belem-pa-num-531"),new BrazilPlateService());
		List<Vehicle> list = Arrays.asList(v1);
		repository.saveAll(list);
	}

}
