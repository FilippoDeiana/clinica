package com.corso.clinica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.corso.clinica.entities.AnimaleEntity;
import com.corso.clinica.services.AnimaleService;
import com.corso.clinica.services.VisitaService;

@Controller
@RequestMapping("/animale")
public class AnimaleController {
	
	@Autowired
	private AnimaleService animaleService;
	@Autowired
	private VisitaService visitaService;
	
	@GetMapping("/lista")
	public String lista(Model model) {

		model.addAttribute("animali", animaleService.listaAll());

		return "listaAnimali";
	}
	
	@GetMapping("/create")
	public String create(Model model) {

		AnimaleEntity animaleEntity = new AnimaleEntity();
		model.addAttribute("animale", animaleEntity);
		return "createAnimale";
	}
	
	@PostMapping("/create")
	public String save(@ModelAttribute AnimaleEntity animaleEntity, Model model) {

		animaleService.save(animaleEntity);
		model.addAttribute("animale", animaleEntity);
		
		
		return "redirect:/animale/lista";
	}
	
	@GetMapping("/update/{id}")
	public String edit(@PathVariable long id, Model model) {

		model.addAttribute("animale", animaleService.findById(id));

		return "updateAnimale";
	}
	
	@PostMapping("/update/{id}")
	public String update(@ModelAttribute AnimaleEntity animaleEntity) {
	
		animaleService.update(animaleEntity);
		
		return "redirect:/animale/lista";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable long id, Model model) {

		animaleService.delete(id);
		
		return "redirect:/animale/lista";
	}
	
	
	@GetMapping("/{id}")
	public String animaleById(@PathVariable Long id, Model model) {

		
		model.addAttribute("animale", animaleService.findById(id));
		model.addAttribute("visite", visitaService.listaAll());
		
		return "animale";
	}

}
