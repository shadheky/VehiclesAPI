package com.example.demo.repository.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Owner;
import com.example.demo.domain.repositorys.OwnerRepository;
import com.example.demo.exceptions.OwnerNotFoundException;

@Service
public class OwnerRepositoryService {

	@Autowired
	private OwnerRepository ownerRespository;

	public Owner findByCpf(String cpf) {
		
		if(ownerRespository.findByCpf(cpf) == null) {
			throw new OwnerNotFoundException("Owner not found");
		}
		
		return ownerRespository.findByCpf(cpf);
	}
	
	
	
}
