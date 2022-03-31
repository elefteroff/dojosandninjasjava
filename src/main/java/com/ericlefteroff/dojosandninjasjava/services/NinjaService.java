package com.ericlefteroff.dojosandninjasjava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericlefteroff.dojosandninjasjava.models.Ninja;
import com.ericlefteroff.dojosandninjasjava.repos.NinjaRepo;

@Service
public class NinjaService {

//	DEPENDENCY INJECTION FOR SERVICE
	@Autowired
	private NinjaRepo ninjaRepo;
	
//	READ ALL
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
	
//	CREATE
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}	

//	READ ONE
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
//	UPDATE
	public Ninja updateNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
//	DELETE
	public void deleteDojo(Long id) {
		ninjaRepo.deleteById(id);
	}
}
