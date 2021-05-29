package com.quintinbowman.NewGenesis.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "workouts")
public class Workout {
	
	public Workout() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date workoutDate;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="trainer_id")
	private Trainer trainer;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getWorkoutDate() {
		return workoutDate;
	}

	public void setWorkoutDate(Date workoutDate) {
		this.workoutDate = workoutDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	
}

