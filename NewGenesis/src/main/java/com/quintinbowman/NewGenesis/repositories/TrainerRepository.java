package com.quintinbowman.NewGenesis.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quintinbowman.NewGenesis.models.Trainer;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer, Long>{
	List<Trainer> findAll();
	boolean existsByEmail(String email);
	Trainer findByEmail(String email);
	boolean existsById(Long id);
	Optional<Trainer> findById(Long id);
}
