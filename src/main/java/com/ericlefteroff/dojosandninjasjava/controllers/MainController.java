package com.ericlefteroff.dojosandninjasjava.controllers;

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

import com.ericlefteroff.dojosandninjasjava.models.Dojo;
import com.ericlefteroff.dojosandninjasjava.models.Ninja;
import com.ericlefteroff.dojosandninjasjava.services.DojoService;
import com.ericlefteroff.dojosandninjasjava.services.NinjaService;


@Controller
public class MainController {

//	DEPENDENCY INJECTION FOR THE SERVICE
	@Autowired
	private NinjaService ninjaServ;
	
	@Autowired
	private DojoService dojoServ;

//	CREATE NINJA RENDER
	@GetMapping("/ninjas/new")
	public String newNinjas(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojosByName=dojoServ.allDojos();
		model.addAttribute("dojo", dojosByName);
		return "NewNinja.jsp";
	}
	
//	CREATE NINJA POST
	@PostMapping("/newNinja")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja,
								BindingResult res) {
		if (res.hasErrors()) {
			return "NewNinja.jsp";
		} else {
			ninjaServ.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
	
//	CREATE DOJO RENDER
	@GetMapping("/dojos/new")
	public String newDojos(@ModelAttribute("dojo") Dojo dojo, Model model) {
		return "NewDojo.jsp";
	}
	
//	CREATE DOJO POST
	@PostMapping("/newDojo")
	public String buildDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult res) {
		System.out.println("TEST1");
		if (res.hasErrors()) {
			System.out.println("TEST2");
			return "NewDojo.jsp";
		} else {
			dojoServ.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	
//	READ ONE
	@GetMapping("/dojos/{dojo_id}")
	public String showDojo(@PathVariable("dojo_id") Long dojo_id, Model model) {
	    Dojo someCoolDojo = dojoServ.findDojo(dojo_id);
	    model.addAttribute("dojo", someCoolDojo);
	    return "ShowDojo.jsp";
	}
	
}
