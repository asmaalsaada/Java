package com.codingdojo.dojo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojo.models.Dojo;
import com.codingdojo.dojo.repositories.DojoRepository;
@Service
public class DojoService {
	final private DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		super();
		this.dojoRepository = dojoRepository;	
	}
	public List<Dojo> allDojo(){
		return dojoRepository.findAll();
	}
	//create dojo 
	public Dojo create(Dojo d) {
		return dojoRepository.save(d);
	}
//	public List<Dojo> nullNinja(){
//		return dojoRepository.findByNinjaIdIsNull();
//	}
	public Dojo findById(Long id ) {
		return dojoRepository.findById(id).orElse(null);
	}
}
