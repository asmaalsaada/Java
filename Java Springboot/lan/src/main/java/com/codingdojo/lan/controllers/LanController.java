package com.codingdojo.lan.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lan.models.Language;
import com.codingdojo.lan.services.LanguageService;
@Controller
public class LanController {
private final LanguageService languageService;

public LanController(LanguageService languageService) {
	this.languageService = languageService;
}
    
@RequestMapping("/languages")
public String index(Model model,@Valid @ModelAttribute("Language") Language Language) {
    List<Language> languages = languageService.allLanguages();
    model.addAttribute("language", languages);
    return "index.jsp";
}

@RequestMapping(value="/languages", method=RequestMethod.POST)
public String create(@Valid @ModelAttribute("language") Language language, BindingResult result,Model model) {
    if (result.hasErrors()) {
        return "index.jsp";
    } else {
        languageService.createLanguage(language);
        return "redirect:/languages";
    }
    
    } 
@RequestMapping("/languages/{id}")
public String show(@PathVariable("id") Long id, Model model) {
	Language language = languageService.findLanguage(id);
	model.addAttribute("language", language);
	return "show.jsp";
}
@RequestMapping("/languages/edit/{id}")
public String edit(@PathVariable("id") Long id, Model model) {
	Language language = languageService.findLanguage(id);
    model.addAttribute("language", language);
    return "edit.jsp";
}

@RequestMapping(value="/update/{id}",method=RequestMethod.PUT)
public String updateLang(@Valid @ModelAttribute  @PathVariable(value="id") Long id , @RequestParam("name")String name, @RequestParam("creator")String creator, @RequestParam("version")String version ) {
    	languageService.updateLanguage(id,name,creator,version);
        return "redirect:/languages";
        }
@RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
public String destroy(@PathVariable("id") Long id) {
	languageService.deleteLanguage(id);
    return "redirect:/languages";
}


}
