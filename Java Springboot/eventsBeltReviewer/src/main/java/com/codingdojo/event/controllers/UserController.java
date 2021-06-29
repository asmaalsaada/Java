package com.codingdojo.event.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.event.models.User;
import com.codingdojo.event.services.AppService;
import com.codingdojo.event.validator.UserValidator;

@Controller
public class UserController {
private final AppService appService;
private final UserValidator userValidator;


public UserController(AppService appService, UserValidator userValidator) {
	super();
	this.appService = appService;
	this.userValidator = userValidator;
}
@RequestMapping("/registration")
public String registerForm(@ModelAttribute("user") User user,HttpSession session) {
//	if (session.getAttribute("userId")!=null) {
//		 return "redirect:/events";
//	 } to be uncommented once done
    return "index.jsp";
}

@RequestMapping(value="/registration", method=RequestMethod.POST)
public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session,Model model) {
	 userValidator.validate(user, result);
	 if(result.hasErrors()){
		 return "index.jsp"; // if result has errors, return the registration page (don't worry about validations just now)
	 } if (appService.findByEmail(user.getEmail()) != null){
		 model.addAttribute("error", "This email already exists");
		 return "index.jsp";
	 } else {
		 appService.registerUser(user);
		 session.setAttribute("userId", user.getId());
		 return "redirect:/events"; //view events page
	 }
    // else, save the user in the database, save the user id in session, and redirect them to the /home route
}

@RequestMapping(value="/login", method=RequestMethod.POST)
public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
	 
	 if(appService.authenticateUser(email, password)) {
		 Long id = appService.findByEmail(email).getId();
		 session.setAttribute("userId", id);
		 return "redirect:/events";
	 } else {
		 model.addAttribute("error", "Invalid User name or Password");
		 return "index.jsp";
	 }
//	 
	 // if the user is authenticated, save their user id in session
    // else, add error messages and return the login page
}

@RequestMapping("/logout")
public String logout(HttpSession session) {
    // invalidate session
	 session.invalidate();
    // redirect to login page
	 return "redirect:/registration";
}

}
