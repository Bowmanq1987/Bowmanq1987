package com.quintinbowman.NewGenesis.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quintinbowman.NewGenesis.models.Workout;
@Repository
public interface WorkoutRepository extends CrudRepository<Workout, Long> {
	List<Workout> findAll();
	boolean existsById(Long id);
	Optional<Workout> findById(Long id);
}
