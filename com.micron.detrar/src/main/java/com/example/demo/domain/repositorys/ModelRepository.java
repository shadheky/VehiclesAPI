package com.example.demo.domain.repositorys;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.Model;

public interface ModelRepository extends JpaRepository<Model, Long>{

	@Query(value = "select * from TB_MODEL where model_name like %?%", nativeQuery = true)
	@Transactional
	List<Model> findByNameLike(String name);
}
