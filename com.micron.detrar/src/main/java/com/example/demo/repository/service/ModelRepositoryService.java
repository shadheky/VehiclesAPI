package com.example.demo.repository.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Model;
import com.example.demo.domain.dto.ModelDTO;
import com.example.demo.domain.enums.VehicleType;
import com.example.demo.domain.repositorys.ModelRepository;
import com.example.demo.exceptions.IllegalDateStringException;

@Service
public class ModelRepositoryService {

	@Autowired
	private ModelRepository repository;

	public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy");
	
	
	public List<Model> findByName(String modelName){
		
		return repository.findByNameLike(modelName);
		
	}
	
	public Model save(ModelDTO modelDto){
		
		String brand = modelDto.getBrand();
		String modelName  = modelDto.getModelName();
		
		Calendar fabricationCalendar = Calendar.getInstance();
		
		
		Calendar modelCalendar = Calendar.getInstance();
		
		try {
			modelCalendar.setTime(SDF.parse(modelDto.getModelYear()));
			fabricationCalendar.setTime(SDF.parse(modelDto.getFabricationYear()));
		}
		catch(ParseException e){
			throw new IllegalDateStringException("Invalid date the format is (yyyy)");		
			}
		
		return repository.save(new Model(brand, modelName, fabricationCalendar, modelCalendar, VehicleType.valueOf(modelDto.getType()), modelDto.getQuantityOfPassengers()));
		
	}
	
}
