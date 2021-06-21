package com.codingdojo.lan.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import com.codingdojo.lan.models.Language;
import com.codingdojo.lan.repositories.LanguageRepository;
@Service
public class LanguageService {
 private final LanguageRepository languageRepository ;
 
 public LanguageService(LanguageRepository languageRepository) {
	this.languageRepository = languageRepository;
}
// returns all the languages
 public List<Language> allLanguages() {
     return languageRepository.findAll();
 }
 // creates a language
 public Language createLanguage(Language l) {
     return languageRepository.save(l);
 }
 // retrieves a language
 public Language findLanguage(Long id) {
     Optional<Language> optionalLanguage = languageRepository.findById(id);
     if(optionalLanguage.isPresent()) {
         return optionalLanguage.get();
     } else {
         return null;
     }
 }
 public Language updateLanguage(Long id,String name, String creator, String version) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			Language l = optionalLanguage.get();
			l.setName(name);
			l.setCreator(creator);
			l.setVersion(version);
			return languageRepository.save(l);
		} else {
			return null;
		}
	}
public void editLanguage(@Valid Language language) {
	languageRepository.save(language);
}
public void deleteLanguage(Long id) {
	Optional<Language> optionalLanguage = languageRepository.findById(id);
	if (optionalLanguage.isPresent()) {
		Language l = optionalLanguage.get();
		languageRepository.delete(l);
	}
	
}

 
}

