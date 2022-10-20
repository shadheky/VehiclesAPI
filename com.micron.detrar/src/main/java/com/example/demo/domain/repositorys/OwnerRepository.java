package com.example.demo.domain.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.Owner;

public interface OwnerRepository extends JpaRepository<Owner,Long> {

	@Query
	Owner findByCpf(String cpf);
}
