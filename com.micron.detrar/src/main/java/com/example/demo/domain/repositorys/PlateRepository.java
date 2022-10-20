package com.example.demo.domain.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Plate;

@Repository
public interface PlateRepository extends JpaRepository<Plate, Long>{

	@Query
	Plate findByPlateValue(String plateValue);

	
	
}
