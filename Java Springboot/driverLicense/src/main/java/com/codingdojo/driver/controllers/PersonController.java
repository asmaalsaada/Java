package com.codingdojo.driver.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.driver.models.License;
import com.codingdojo.driver.models.Person;
import com.codingdojo.driver.services.PersonService;
@Controller
public class PersonController {
private final PersonService personService;
public PersonController(PersonService personService) {
		this.personService = personService;
	}
@RequestMapping("/persons/new")
public String home(@ModelAttribute("Person") Person person) {
	return "index.jsp";
}
@RequestMapping(value="/newPerson",method=RequestMethod.POST)
public String newPerson(@Valid @ModelAttribute("Person") Person person,BindingResult result) {
	if(result.hasErrors()) {
		return "index.jsp";
	}else {
			personService.create(person);
			return "redirect:/license/new";
		}
	}
@RequestMapping("/license/new")
public String license(@Valid Model model,@ModelAttribute("License") License license) {
	List<Person> p = personService.isNullLicense();
	model.addAttribute("Person", p);
	return "newLicense.jsp";
}
@RequestMapping("/profile/{id}")
public String show(@PathVariable("id") Long id ,Model model,@ModelAttribute("License") License license) {
	Person per = personService.findById(id);
	model.addAttribute("person", per);
	return "profile.jsp";
}
	
}
