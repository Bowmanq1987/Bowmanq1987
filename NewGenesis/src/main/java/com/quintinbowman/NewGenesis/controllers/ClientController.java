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

import com.quintinbowman.NewGenesis.models.Client;
import com.quintinbowman.NewGenesis.models.Trainer;
import com.quintinbowman.NewGenesis.models.Workout;
import com.quintinbowman.NewGenesis.services.ClientServices;
import com.quintinbowman.NewGenesis.services.TrainerServices;
import com.quintinbowman.NewGenesis.services.WorkoutServices;
import com.quintinbowman.NewGenesis.validations.ClientValidation;

@Controller
public class ClientController {
	@Autowired
	private ClientServices cService;
	@Autowired
	private ClientValidation cValidation;
	@Autowired
	private TrainerServices tService;
	@Autowired
	private WorkoutServices wService; 
	
	@GetMapping("/")
	//Welcome page
	public String welcome() {
		return "welcome.jsp";
	}
	
	@GetMapping("/clientRegistration")
	//Registration page
	public String index(@ModelAttribute("client") Client client) {
		return "clientRegistration.jsp";
	}
	
	@PostMapping("/clientRegistration")
	public String register(@Valid @ModelAttribute("client") Client client, BindingResult result, HttpSession session) {
		//Checks to make sure all the inputs are valid
		cValidation.validate(client, result);
		if(result.hasErrors()) {
			return "clientRegistration.jsp";
		} else {
		
	//Takes them to the login page after they register
	Client newClient = this.cService.registerClient(client);
	session.setAttribute("client_id", newClient.getId());
	return "redirect:/clientLogin";
		}
	}
	
	//Takes the client to the login page if they already registered.
	@GetMapping("/clientLogin")
	public String login() {
		return "clientLogin.jsp";
	}
	
	// Checks to see if the login credentials are correct
	@PostMapping("/clientLogin")
	public String login(@RequestParam("loginemail") String email, @RequestParam("loginpassword") String password, RedirectAttributes eMessage, HttpSession session) {
		if(!this.cService.authenticateClient(email, password)) {
		eMessage.addFlashAttribute("loginError", "Try again");
			return "clientLogin.jsp";
			} else {
	Client client = this.cService.getByEmail(email);
		session.setAttribute("client_id", client.getId());
		return "redirect:/clientProfile";
			}
	}
	
	//Logs the user out
	@GetMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes redirectors) {
	session.invalidate();
	redirectors.addFlashAttribute("logout", "You successfully ended your session with us.");
	return "redirect:/";
			}
			
	//Profile page that show their selection along with an about me section
	@GetMapping("/clientProfile")
	public String aboutClient(HttpSession session, Model viewModel) {
		if(session.getAttribute("client_id") == null) {
			return "redirect:/clientLogin";
		} else {
		Client currentClient = cService.getById((Long)session.getAttribute("client_id"));
		viewModel.addAttribute("client", currentClient);
		return "clientProfile.jsp";
			}
	}
	
	//Takes the person to the edit page to update their profile
	@GetMapping("/edit/{id}")
	public String editClient(@PathVariable("id") Long id, @ModelAttribute("client")Client client, Model viewModel) {
	viewModel.addAttribute("client", this.cService.getById(id));
	return "edit.jsp";
			}
	
	//Save what the person edited on their page
	@PostMapping("/edit/{id}")
	public String editClient(@PathVariable("id")Long id, @Valid@ModelAttribute("client")Client client, BindingResult results, Model viewModel) {
	viewModel.addAttribute("client", this.cService.getById(id));
	if(results.hasErrors()) {
		return "edit.jsp";
			} else {
	this.cService.updateClient(client);
	return "redirect:/clientProfile/";
			}
	}
	
	//takes to the search page to match them with trainer who's style match their profile
	@GetMapping("/findTrainer")
	public String matchClient(HttpSession session, Model viewModel) {
		Client currentClient = cService.getById((Long)session.getAttribute("client_id"));
		viewModel.addAttribute("client", currentClient);
		viewModel.addAttribute("trainer", tService.getTrainers());
		return "search.jsp";
	}
	
	//Takes the client to a page to select a date and schedule the workout
	@GetMapping("/createWorkout/{id}")
	public String displayWorkout(@PathVariable("id")Long id, @ModelAttribute("workouts")Workout workout, HttpSession session, Model viewModel) {
		if(session.getAttribute("client_id") == null) {
			Client currentClient = cService.getById((Long)session.getAttribute("client_id"));
			viewModel.addAttribute("client", currentClient);
			viewModel.addAttribute("trainer", tService.getTrainers());
			return "redirect:/findTrainer";
		}
		Client currentClient = cService.getById((Long)session.getAttribute("client_id"));
		viewModel.addAttribute("client", currentClient);
		viewModel.addAttribute("trainer", this.tService.getById(id));
		viewModel.addAttribute(workout);
		return "workout.jsp";
				}
	
	//Creates a new workout and display the date under their info
	@PostMapping("/createWorkout/{id}")
	public String newWorkout(@Valid @ModelAttribute("workouts") Workout workout, BindingResult results, @PathVariable("id")Long id, Model viewModel, HttpSession session) {
		System.out.print(workout);
		Trainer trainer = this.tService.getById(id);
		if(results.hasErrors()) {
			Client currentClient = cService.getById((Long)session.getAttribute("client_id"));
			viewModel.addAttribute("client", currentClient);
			viewModel.addAttribute("trainer", tService.getTrainers());
			return "workout.jsp";
		} else {
			Long client_id = (Long)session.getAttribute("client_id");
			Client client = cService.getById(client_id);
			workout.setClient(client);
			workout.setTrainer(trainer);
			this.wService.create(workout);
		return "redirect:/findTrainer";
		}
	}
}
