package com.quintinbowman.NewGenesis.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.quintinbowman.NewGenesis.models.Client;
import com.quintinbowman.NewGenesis.repositories.ClientRepository;

@Component
public class ClientValidation {
	@Autowired
	private ClientRepository cRepo;
	
	public boolean supports(Class<?> clazz) {
		return Client.class.equals(clazz);
	}
	
	public void validate (Object target, Errors errors) {
		Client client = (Client) target;
	
	//checks the password
	if(!client.getPassword().equals(client.getConfirmPassword())) {
		errors.rejectValue("password", "Match", "You do not know the way, try again!!!");
		}
	//checks the email
	if(this.cRepo.existsByEmail(client.getEmail())) {
		errors.rejectValue("email", "Unique", "Nice try, but you've already been here.");
		} 
	}
	
	public void validateText(Object target, Errors errors) {
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "aboutMe",
             "required.aboutMe", "Field name is required.");
        
    }
}
