package com.quintinbowman.NewGenesis.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quintinbowman.NewGenesis.models.Client;
import com.quintinbowman.NewGenesis.repositories.ClientRepository;

@Service
public class ClientServices {
	@Autowired
	private ClientRepository cRepo;
	
		// Registers the User
		public Client registerClient(Client client) {
			// Makes the hash
			String hash = BCrypt.hashpw(client.getPassword(), BCrypt.gensalt());
			// Place the hash on the password
			client.setPassword(hash);
			// Save new password and user to database
			return this.cRepo.save(client);
		}
		// Login existing User
		public boolean authenticateClient(String email, String password) {
			// Make sure the person logging in is who they say they are
			// Step 1. try and query user by email
			Client client = this.cRepo.findByEmail(email);
			if(client == null) {
				return false;
			}
			// Step 2. check email against database user email
			return BCrypt.checkpw(password, client.getPassword());
	 	}
		// Get All
		public List<Client> getClients(){
		return this.cRepo.findAll();
		}
		// Get One
		public Client getById(Long id) {
			return this.cRepo.findById(id).orElse(null);
		}
		// Create
		public Client create(Client clients) {
			return this.cRepo.save(clients);
		}
		// Delete
		public void delete(Long id) {
			this.cRepo.deleteById(id);
		}
		//Get one by email
		public Client getByEmail(String email) {
			return this.cRepo.findByEmail(email);
		}
		//Update 
		public void updateClient(Client clients) {
			this.cRepo.save(clients);
		}
}
