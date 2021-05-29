package com.quintinbowman.NewGenesis.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.quintinbowman.NewGenesis.models.Trainer;
import com.quintinbowman.NewGenesis.repositories.TrainerRepository;

@Component
public class TrainerValidation {
	@Autowired
	private TrainerRepository tRepo;
	
	public boolean supports(Class<?> clazz) {
		return Trainer.class.equals(clazz);
	}
	
	public void validate (Object target, Errors errors) {
		Trainer trainer = (Trainer) target;
	
	//checks the password
	if(!trainer.getPassword().equals(trainer.getConfirmPassword())) {
		errors.rejectValue("password", "Match", "You do not know the way, try again!!!");
		}
		//checks the email
		if(this.tRepo.existsByEmail(trainer.getEmail())) {
			errors.rejectValue("email", "Unique", "Nice try, but you've already been here.");
		} 
	}
	
	public void validateText(Object target, Errors errors) {
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "aboutMe",
             "required.aboutMe", "Field name is required.");
        
    }
}
