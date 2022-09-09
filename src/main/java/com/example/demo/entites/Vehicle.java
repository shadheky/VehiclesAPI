package com.example.demo.entites;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Repository;

@Repository
public abstract class Vehicle implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id	
	private String id;
	private String model;
	private String plate;
	private Owner owner;
	
	
	public Vehicle() {
		
	}

	public Vehicle(String id, String model, String plate, Owner owner) {
		super();
		this.id = id;
		this.model = model;
		this.plate = plate;
		this.owner = owner;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
