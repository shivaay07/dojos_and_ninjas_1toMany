package com.duttech.dojos_and_ninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duttech.dojos_and_ninjas.models.Dojo;
import com.duttech.dojos_and_ninjas.models.Ninja;
import com.duttech.dojos_and_ninjas.services.DojoService;
import com.duttech.dojos_and_ninjas.services.NinjaService;

@Controller
public class MainController {
	
	@Autowired
	private DojoService dojoServe;
	@Autowired
	private NinjaService ninjaServe;
	

//	Create new dojo---------------------------
	@GetMapping("/dojos/new")
	public String index(@ModelAttribute Dojo dojo, Model model) {
		List<Dojo> newDojos = dojoServe.allDojos();
		model.addAttribute("newDojos", newDojos);
		return "/dojos/index.jsp";
	}
	@PostMapping(path="/new/dojo")
	public String newDojo(@Valid @ModelAttribute Dojo dojo, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> newDojos = dojoServe.allDojos();
			model.addAttribute("newDojos", newDojos);
			return "/dojos/index.jsp";
		}else {
			dojoServe.newDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
		
//	Create new Ninja
	@GetMapping("/ninjas/new")
	public String ninjaIndex(@ModelAttribute Ninja ninja, Model model) {
		List<Dojo> newDojos = dojoServe.allDojos();
		model.addAttribute("newDojos", newDojos);
		List<Ninja> allNinjas = ninjaServe.allNinjas();
		model.addAttribute("allNinjas", allNinjas);
		return "/dojos/ninjas.jsp";
	}
	@PostMapping(path="/new/ninja")
	public String newNinja(@Valid @ModelAttribute Ninja ninja,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "/dojos/ninjas.jsp";
		}else {
			ninjaServe.newNinja(ninja);
			return "redirect:/ninjas/new";
			
		}
	}
		
//	Ninjas with dojo locations
	
	@RequestMapping("/dojo/{id}")
	public String findDojo(@PathVariable("id") Long id, Model model) {
		Dojo foundDojo = dojoServe.aDojo(id);
		List<Ninja> dojoNinjas = ninjaServe.allNinjas();
		model.addAttribute("dojoNinjas", dojoNinjas);
		model.addAttribute("foundDojo", foundDojo);
		return "/dojos/dojos.jsp";
		
	}
	
}
