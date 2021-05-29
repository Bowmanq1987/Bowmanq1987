package com.quintinbowman.NewGenesis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quintinbowman.NewGenesis.models.Workout;
import com.quintinbowman.NewGenesis.repositories.WorkoutRepository;

@Service
public class WorkoutServices {
	@Autowired
	private WorkoutRepository wRepo;
	
	// Get All
			public List<Workout> getWorkout(){
			return this.wRepo.findAll();
			}
			// Get One
			public Workout getById(Long id) {
				return this.wRepo.findById(id).orElse(null);
			}
			// Create
			public Workout create(Workout workout) {
				return this.wRepo.save(workout);
			}
			// Delete
			public void delete(Long id) {
				this.wRepo.deleteById(id);
			}
			//Update 
			public void updateWorkout(Workout workout) {
				this.wRepo.save(workout);
			}
			
			
}
