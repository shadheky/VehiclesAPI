package com.example.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelDTO {

	private String brand;
	private String modelName;
	
	private String fabricationYear;
	private String modelYear;
	
	private String type;
	private Integer quantityOfPassengers;
}
