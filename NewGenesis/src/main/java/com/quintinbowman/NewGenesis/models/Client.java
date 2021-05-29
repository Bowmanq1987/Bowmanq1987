package com.quintinbowman.NewGenesis.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clients")
public class Client {

	public Client() {
	
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//Primary key for the client model
	private long id;
	
	@NotBlank
	@Size(max=50)
	private String name;
	
	@NotBlank
	@Email(message="Email must be valid, and in email format")
	private String email;
	
	@NotBlank
	private String address;
	
	@NotBlank
	private String city;
	
	@NotBlank
	@Size(max=2)
	private String state;
	
	@NotBlank
	@Size(min=8, message="Password must be greater than 8 characters")
	private String password;
	
	@Transient
	// Doesn't show in the Database but validates the password
	private String confirmPassword;
	
	private String[]fitnessList;
	
	private String aboutMe;
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
       
    @OneToMany(mappedBy="client",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Workout> personalTrainers;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String[] getFitnessList() {
		return fitnessList;
	}

	public void setFitnessList(String[] fitnessList) {
		this.fitnessList = fitnessList;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Workout> getPersonalTrainers() {
		return personalTrainers;
	}

	public void setWorkout(List<Workout> personalTrainers) {
		this.personalTrainers = personalTrainers;
	}

}
