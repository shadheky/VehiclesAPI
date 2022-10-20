package com.example.demo.domain.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDTO {

	@NotEmpty(message="name field can't be empty")
	private String name;
	
	@CPF(message="Invalid cpf")
	private String cpf;
	
}
