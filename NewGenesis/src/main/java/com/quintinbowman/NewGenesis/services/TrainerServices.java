package com.quintinbowman.NewGenesis.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quintinbowman.NewGenesis.models.Trainer;
import com.quintinbowman.NewGenesis.repositories.TrainerRepository;

@Service
public class TrainerServices {
	@Autowired
	private TrainerRepository tRepo;
	
	// Registers the User
			public Trainer registerTrainer(Trainer trainer) {
				// Makes the hash
				String hash = BCrypt.hashpw(trainer.getPassword(), BCrypt.gensalt());
				// Place the hash on the password
				trainer.setPassword(hash);
				// Save new password and user to database
				return this.tRepo.save(trainer);
			}
			// Login existing User
			public boolean authenticateTrainer(String email, String password) {
				// Make sure the person logging in is who they say they are
				// Step 1. try and query user by email
				Trainer trainer = this.tRepo.findByEmail(email);
				if(trainer == null) {
					return false;
				}
				// Step 2. check email against database user email
				return BCrypt.checkpw(password, trainer.getPassword());
		 	}
			// Get All
			public List<Trainer> getTrainers(){
			return this.tRepo.findAll();
			}
			// Get One
			public Trainer getById(Long id) {
				return this.tRepo.findById(id).orElse(null);
			}
			// Create
			public Trainer create(Trainer trainers) {
				return this.tRepo.save(trainers);
			}
			// Delete
			public void delete(Long id) {
				this.tRepo.deleteById(id);
			}
			//Get one by email
			public Trainer getByEmail(String email) {
				return this.tRepo.findByEmail(email);
			}
			//Update 
			public void updateTrainer(Trainer trainers) {
				this.tRepo.save(trainers);
			}
}
