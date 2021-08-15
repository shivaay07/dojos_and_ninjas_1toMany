package com.duttech.dojos_and_ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duttech.dojos_and_ninjas.models.Dojo;
import com.duttech.dojos_and_ninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepository dojoRepo;

	
//	All Crud Operations
	
//	1) To retrieve list of all dojos
	
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
//	2) To create new Dojo
	
	public Dojo newDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
//	3) read(find) single dojo with dojo id
	
	public Dojo aDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}else {
			return null;
		}
	}
	
//	4) to update the dojo
	
	public Dojo updateDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
//	5) to delete a dojo
	
	public void destroyDojo(Long id) {
		Optional<Dojo> delDojo = dojoRepo.findById(id);
		if(delDojo.isPresent()) {
			dojoRepo.deleteById(id);
		}
	}
	
}
