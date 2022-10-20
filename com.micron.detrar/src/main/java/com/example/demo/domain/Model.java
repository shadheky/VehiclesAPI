package com.example.demo.domain;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.domain.enums.VehicleType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_MODEL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="Marca")
	private String brand;

	@Column(name="Nome_do_modelo")
	private String modelName;

	@Column (name="Ano_Do_Modelo")
	private Integer fabricationYear;
	
	@Column (name="Ano_De_Fabricacao")
	private Integer modelYear;
	
	@Column(name="Quantidade_De_Passageiros")
	private Integer quantityOfPassengers;
	
	@Column(name="Tipo_de_veiculos")
	@Enumerated(EnumType.STRING)
	private VehicleType type;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "model", fetch = FetchType.LAZY)
	private Set<Vehicle> vehicles = new HashSet<>();

	public Model(String brand, String modelName, Calendar fabricationDate, Calendar modelDate, VehicleType type, Integer quantityOfPassengers) {
		this.brand = brand;
		this.modelName = modelName;
		this.type= type;
		this.fabricationYear = fabricationDate.get(Calendar.YEAR);
		this.modelYear = modelDate.get(Calendar.YEAR);
		this.quantityOfPassengers = quantityOfPassengers;
}


}
