package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.domain.enums.VehicleType;

import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="vehicle")
@NoArgsConstructor
@Data
public class Vehicle implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date purchaseDate;
	
	@Column
	private String color;
	
	@Column
	private String renavam;
	
	@ManyToOne
	private Model model;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="owner_cpf")
	private Owner owner;
	
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="plate")
	private Plate plate;
	
	@Enumerated(EnumType.STRING)
	@Column
	private VehicleType type;
	
	public Vehicle(Date purchaseDate, Plate plate, String renavam, Owner owner, Model model, String color) {	
		this.purchaseDate = purchaseDate;
		this.plate = plate;
		this.renavam = renavam;
		this.owner = owner;
		this.model = model;
		this.color = color;
		this.type = model.getType();
	}
	


	
	

	
}
