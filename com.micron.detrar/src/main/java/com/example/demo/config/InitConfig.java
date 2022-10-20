package com.example.demo.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.domain.Model;
import com.example.demo.domain.Owner;
import com.example.demo.domain.Plate;
import com.example.demo.domain.Vehicle;
import com.example.demo.domain.enums.VehicleType;
import com.example.demo.domain.repositorys.ModelRepository;
import com.example.demo.domain.repositorys.PlateRepository;
import com.example.demo.domain.repositorys.VehicleRepository;
import com.example.demo.domain.services.BrazilPlateService;

@Configuration
public class InitConfig {

	@Autowired
	private VehicleRepository repository;
	
	@Autowired
	private PlateRepository plateRepository;
	

	
	@Autowired
	private ModelRepository modelRepository;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	@Bean
	public void inicializarVeiculos() throws ParseException {
		
		
		Plate p1 = new Plate("Belem-PA", new BrazilPlateService());
		
		
		//Owner o1 = new Owner(null,"Luiz Alberto", "01409489299");
		
		 Calendar data = Calendar.getInstance();
		
		Model m1 = new Model("Chevrolet","Onix", data,data, VehicleType.CAR, 5);
		modelRepository.save(m1);
		
		//Model m2 = new Model(null, "CHEVROLET", "Onix",new Date() ,new Date(),VehicleType.CAR);
		//modelRepository.save(m2);
		
		
		Vehicle v1 = new Vehicle(new Date(), p1, "1111111111-1", new Owner(), m1, "azul");
		p1.setVehicleId(v1);	
		//o1.addVehicle(v1);
		
		
		repository.saveAll(Arrays.asList(v1));
		plateRepository.save(p1);
		
		
		
		
		
		
	}
}
