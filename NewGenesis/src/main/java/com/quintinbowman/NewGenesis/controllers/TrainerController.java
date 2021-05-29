package com.quintinbowman.NewGenesis.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.quintinbowman.NewGenesis.models.Trainer;
import com.quintinbowman.NewGenesis.services.TrainerServices;
import com.quintinbowman.NewGenesis.validations.TrainerValidation;

@Controller
public class TrainerController {
	@Autowired
	private TrainerServices tService;
	@Autowired
	private TrainerValidation tValidation;
	
	@GetMapping("/trainerRegistration")
	//Registration page
	public String index(@ModelAttribute("trainer") Trainer trainer) {
		return "trainerRegistration.jsp";
	}
	
	@PostMapping("/trainerRegistration")
	public String register(@Valid @ModelAttribute("trainer") Trainer trainer, BindingResult result, HttpSession session) {
		//Checks to make sure all the inputs are valid
		tValidation.validate(trainer, result);
		if(result.hasErrors()) {
			return "trainerRegistration.jsp";
		} else {
		
	//Takes them to the login page after they register
	Trainer newTrainer = this.tService.registerTrainer(trainer);
	session.setAttribute("trainer_id", newTrainer.getId());
	return "trainerLogin.jsp";
		}
	}
	
	//Takes the client to the login page if they already registered.
		@GetMapping("/trainerLogin")
		public String login() {
			return "trainerLogin.jsp";
		}
		
		// Checks to see if the login credentials are correct
		@PostMapping("/trainerLogin")
		public String login(@RequestParam("loginemail") String email, @RequestParam("loginpassword") String password, RedirectAttributes eMessage, HttpSession session) {
			if(!this.tService.authenticateTrainer(email, password)) {
			eMessage.addFlashAttribute("loginError", "Try again");
				return "trainerLogin.jsp";
					} else {
			Trainer trainer = this.tService.getByEmail(email);
			session.setAttribute("trainer_id", trainer.getId());
			return "redirect:/trainerProfile";
				}
		}
		
		//Profile page that show their selection along with an about me section
		@GetMapping("/trainerProfile")
		public String aboutTrainer(HttpSession session, Model viewModel) {
			if(session.getAttribute("trainer_id") == null) {
				return "trainerLogin.jsp";
			} else {
			Trainer currentTrainer = tService.getById((Long)session.getAttribute("trainer_id"));
		viewModel.addAttribute("trainer", currentTrainer);
		return "trainerProfile.jsp";
				}
		}
		
		//Takes the person to the edit page to update their profile
		@GetMapping("/trainerEdit/{id}")
		public String editTrainer(@PathVariable("id") Long id, @ModelAttribute("trainer")Trainer trainer, Model viewModel) {
		viewModel.addAttribute("trainer", this.tService.getById(id));
		return "trainerEdit.jsp";
				}
		
		//Save what the person edited on their page
		@PostMapping("/trainerEdit/{id}")
		public String editTrainer(@PathVariable("id")Long id, @Valid@ModelAttribute("trainer")Trainer trainer, BindingResult results, Model viewModel) {
		viewModel.addAttribute("trainer", this.tService.getById(id));
		if(results.hasErrors()) {
			return "trainerEdit.jsp";
				} else {
		this.tService.updateTrainer(trainer);
		return "redirect:/trainerProfile/"+trainer.getId();
				}
		}
}
