package com.codingdojo.dojo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojo.models.Ninja;
import com.codingdojo.dojo.repositories.NinjaRepository;
@Service
public class NinjaService {
private final NinjaRepository ninjaRepository;

public NinjaService(NinjaRepository ninjaRepository) {
	super();
	this.ninjaRepository = ninjaRepository;
}
public List<Ninja> allNinja(){
	return ninjaRepository.findAll();
}
public Ninja create(Ninja n) {
	return ninjaRepository.save(n);
}
}
