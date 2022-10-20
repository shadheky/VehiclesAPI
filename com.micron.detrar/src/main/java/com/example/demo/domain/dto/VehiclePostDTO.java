package com.example.demo.domain.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiclePostDTO {

	
	@NotEmpty(message="purchaseDate field can't be empty")
	private String purchaseDate;
	
	@NotEmpty(message="renavam field can't be empty")
	private String renavam;
	
	@NotEmpty(message="color field can't be empty")
	private String color;
	
	@NotNull(message="plate field can't be null")
	@Valid
	private PlateDTO plate;
	
	@NotNull(message="modelId field can't be null")
	private Long modelId;
	
	@NotNull(message="owner field can't be null")
	@Valid
	private OwnerDTO owner;
	
	
}
