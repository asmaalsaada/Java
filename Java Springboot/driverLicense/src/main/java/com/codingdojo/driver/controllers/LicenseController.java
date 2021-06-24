package com.codingdojo.driver.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.driver.models.License;
import com.codingdojo.driver.models.Person;
import com.codingdojo.driver.services.LicenseService;
import com.codingdojo.driver.services.PersonService;

@Controller
public class LicenseController {
	final private LicenseService licenseService;
	
	public LicenseController(LicenseService licenseService) {
		this.licenseService = licenseService;
	}

	@RequestMapping("/new/license")
	public String newL(@Valid @ModelAttribute("License") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "newLicense.jsp";
		} else {
			String number = licenseService.generateLicenseNumber();
            license.setNumber(number);
			 licenseService.create(license);
			 return "redirect:/";
		}
		}
	
	
	}
	

