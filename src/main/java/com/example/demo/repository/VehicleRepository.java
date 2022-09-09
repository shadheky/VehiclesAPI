package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entites.Vehicle;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String>{

}
