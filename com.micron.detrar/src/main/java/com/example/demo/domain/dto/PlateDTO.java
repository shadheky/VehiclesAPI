package com.example.demo.domain.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlateDTO {

	@NotEmpty(message="location field can't be empty")
	private String location;
	
	@NotEmpty(message="service field can't be empty")
	private String service;
	
}
