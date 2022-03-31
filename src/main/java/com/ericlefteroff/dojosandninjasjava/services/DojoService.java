package com.ericlefteroff.dojosandninjasjava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericlefteroff.dojosandninjasjava.models.Dojo;
import com.ericlefteroff.dojosandninjasjava.repos.DojoRepo;

@Service
public class DojoService {

//	DEPENDENCY INJECTION FOR SERVICE
	@Autowired
	private DojoRepo dojoRepo;
	
//	READ ALL
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
//	CREATE
	public Dojo createDojo(Dojo dojo) {
		System.out.println(dojo.getDojoName());
		return dojoRepo.save(dojo);
	}	

//	READ ONE
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	
//	UPDATE
	public Dojo updateDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
//	DELETE
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
	
}
