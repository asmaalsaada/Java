package com.codingdojo.dojo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.dojo.models.Dojo;
import com.codingdojo.dojo.models.Ninja;
import com.codingdojo.dojo.services.DojoService;
import com.codingdojo.dojo.services.NinjaService;

@Controller
public class HomeController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	public HomeController(DojoService dojoService, NinjaService ninjaService) {
		super();
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}//must pass model attribute since we will create new object from class
	@RequestMapping("/dojo/new")
	public String home(@ModelAttribute("Dojo") Dojo dojo) { 
		return "index.jsp";
	}
	@RequestMapping(value="/new/dojos", method=RequestMethod.POST)
	public String newDojo( @ModelAttribute("Dojo") Dojo dojo,BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}else {
			dojoService.create(dojo);
			return "redirect:/successDojo";
		}
	}
	@RequestMapping("/ninja/new")
	public String ninjaPage(@ModelAttribute("Ninja") Ninja ninja,Model model) {
		List<Dojo> d = dojoService.allDojo();
		model.addAttribute("dojos", d);//used Model to pass data to frontend
		return "ninjas.jsp";
	}
	@RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
	public String newNinja( @ModelAttribute("Ninja")Ninja ninja,BindingResult result) {
		if(result.hasErrors()) {
			return "ninjas.jsp";
		}else {
			ninjaService.create(ninja);
			return "redirect:/successNinja";
		}
	}
	@RequestMapping("/dojos/{id}")
	public String show(@PathVariable("id") Long id,@ModelAttribute("Ninja") Ninja ninja,Model model) {
		Dojo d = dojoService.findById(id);
		model.addAttribute("dojo",d);
		return "allninjaswithdojo.jsp";
		
	}

}
