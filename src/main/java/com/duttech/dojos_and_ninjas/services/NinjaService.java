package com.duttech.dojos_and_ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duttech.dojos_and_ninjas.models.Ninja;
import com.duttech.dojos_and_ninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
//	All Crud Operations
	
//	1) To retrieve list of all ninjas
	
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
//	2) To create new Ninja
	
	public Ninja newNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
//	3) read(find) single Ninja with Ninja id
	
	public Ninja aNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		}else {
			return null;
		}
	}
	
//	4) to update the ninja
	
	public Ninja updateNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
//	5) to delete a ninja
	
	public void destroyNinja(Long id) {
		Optional<Ninja> delNinja = ninjaRepo.findById(id);
		if(delNinja.isPresent()) {
			ninjaRepo.deleteById(id);
		}
	}

}
