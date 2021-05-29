package com.quintinbowman.NewGenesis.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quintinbowman.NewGenesis.models.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
	List<Client> findAll();
	boolean existsByEmail(String email);
	Client findByEmail(String email);
	boolean existsById(Long id);
	Optional<Client> findById(Long id);
}
