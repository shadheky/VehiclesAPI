package com.example.demo.repository.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Model;
import com.example.demo.domain.Owner;
import com.example.demo.domain.Plate;
import com.example.demo.domain.Vehicle;
import com.example.demo.domain.dto.PlateDTO;
import com.example.demo.domain.dto.VehiclePostDTO;
import com.example.demo.domain.repositorys.ModelRepository;
import com.example.demo.domain.repositorys.OwnerRepository;
import com.example.demo.domain.repositorys.PlateRepository;
import com.example.demo.domain.repositorys.VehicleRepository;
import com.example.demo.domain.services.BrazilPlateService;
import com.example.demo.domain.services.MercosulPlateService;
import com.example.demo.exceptions.DivergentInformationException;
import com.example.demo.exceptions.IllegalDateStringException;
import com.example.demo.exceptions.InvalidPlateServiceException;
import com.example.demo.exceptions.ModelNotFoundException;
import com.example.demo.exceptions.PlateBaseFullException;
import com.example.demo.exceptions.VehicleNotFoundException;

@Service
public class VehicleRepositoryService {
	protected static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	private VehicleRepository repository;
	@Autowired
	private PlateRepository plateRepository;
	@Autowired
	private OwnerRepository ownerRepository;
	@Autowired
	private ModelRepository modelRepository;

	@Transactional
	public Vehicle save(VehiclePostDTO vehicle){

		Vehicle savedVehicle = new Vehicle();

		
		try {
			savedVehicle.setPurchaseDate(sdf.parse(vehicle.getPurchaseDate()));
		}
		catch(ParseException e) {
			throw new IllegalDateStringException("Invali date the format is (yyyy-MM-dddd)");
		}
		
		savedVehicle.setRenavam(vehicle.getRenavam());
		savedVehicle.setColor(vehicle.getColor());
		
		
		
		if (vehicle.getPlate().getService().toUpperCase().equals("BRAZILPLATESERVICE")) {
			if(plateRepository.findAll().size() == 175760000 ) {
				throw new PlateBaseFullException("Brazil plate is full");
			}
			
			String plateValue = new BrazilPlateService().generatedPlate();

			while (plateRepository.findByPlateValue(plateValue) != null) {
				plateValue = new BrazilPlateService().generatedPlate();			
			}
		  	
			
			Plate p1 = new Plate(vehicle.getPlate().getLocation(), new BrazilPlateService());
			p1.setPlateValue(plateValue);
			savedVehicle.setPlate(p1);
			p1.setVehicleId(savedVehicle);

		} else if (vehicle.getPlate().getService().toUpperCase().equals("MERCOSULPLATESERVICE")) {
			if(plateRepository.findAll().size() == 456976000 ) {
				throw new PlateBaseFullException("Mercosul plate is full");
			}
			
			String plateValue = new MercosulPlateService().generatedPlate();

			while (plateRepository.findByPlateValue(plateValue) != null) {
				plateValue = new MercosulPlateService().generatedPlate();					
			}

			
			Plate p1 = new Plate(vehicle.getPlate().getLocation(), new MercosulPlateService());
			p1.setPlateValue(plateValue);
			savedVehicle.setPlate(p1);
			p1.setVehicleId(savedVehicle);

		} else {
			throw new InvalidPlateServiceException("Select service (MERCOSULPLATESERVICE OR BRAZILPLATESERVICE)");
		}

		Owner owner = new Owner();

		if (ownerRepository.findByCpf(vehicle.getOwner().getCpf()) == null) {
			owner.setCpf(vehicle.getOwner().getCpf());
			owner.setName(vehicle.getOwner().getName());

			savedVehicle.setOwner(owner);

		} else if (!(ownerRepository.findByCpf(vehicle.getOwner().getCpf()).getName()
				.equals(vehicle.getOwner().getName()))) {
			throw new DivergentInformationException("This cpf already registered in our data base with other name");
		} else {
			owner = ownerRepository.findByCpf(vehicle.getOwner().getCpf());
			savedVehicle.setOwner(owner);
		}

		Model model = modelRepository.findById(vehicle.getModelId())
				.orElseThrow(() -> new ModelNotFoundException("Model of id "+ vehicle.getModelId() + " not found"));

		savedVehicle.setModel(model);
		owner.addVehicle(savedVehicle);
		savedVehicle.setType(model.getType());
		
		return repository.save(savedVehicle);

	}

	public List<Vehicle> findAll() {

		return repository.findAll();
	}

	public Vehicle findByPlate(String plateValue) {

		Plate plate = plateRepository.findByPlateValue(plateValue);

		if (plate == null) {
			throw new VehicleNotFoundException("No vehicles with this plate " + "(" + plateValue + ")");
		}

		return repository.findByPlate(plate);
	}
	
	
	public void updatePlate(PlateDTO plateDto, String plate) {
		
		Vehicle vehicle = findByPlate(plate);
		Plate deletePlate = vehicle.getPlate();
		if (plateDto.getService().toUpperCase().equals("BRAZILPLATESERVICE")) {
			if(plateRepository.findAll().size() == 175760000 ) {
				throw new PlateBaseFullException("Brazil plate is full");
			}
			
			String plateValue = new BrazilPlateService().generatedPlate();

			while (plateRepository.findByPlateValue(plateValue) != null) {
				plateValue = new BrazilPlateService().generatedPlate();			
			}
		  	
			
			Plate p1 = new Plate(vehicle.getPlate().getLocation(), new BrazilPlateService());
			p1.setPlateValue(plateValue);
			vehicle.setPlate(p1);
			p1.setVehicleId(vehicle);

		} else if (plateDto.getService().toUpperCase().equals("MERCOSULPLATESERVICE")) {
			if(plateRepository.findAll().size() == 456976000 ) {
				throw new PlateBaseFullException("Mercosul plate is full");
			}
			
			String plateValue = new MercosulPlateService().generatedPlate();

			while (plateRepository.findByPlateValue(plateValue) != null) {
				plateValue = new MercosulPlateService().generatedPlate();					
			}

			
			Plate newPlate = new Plate(vehicle.getPlate().getLocation(), new MercosulPlateService());
			newPlate.setPlateValue(plateValue);
			vehicle.setPlate(newPlate);
			newPlate.setVehicleId(vehicle);
			plateRepository.delete(deletePlate);

		} else {
			throw new InvalidPlateServiceException("Select service (MERCOSULPLATESERVICE OR BRAZILPLATESERVICE)");
		}
		repository.save(vehicle);
	
}}
