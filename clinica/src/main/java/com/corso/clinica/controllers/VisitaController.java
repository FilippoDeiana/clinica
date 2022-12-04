package com.corso.clinica.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.corso.clinica.entities.AnimaleEntity;
import com.corso.clinica.entities.VisitaEntity;
import com.corso.clinica.services.AnimaleService;
import com.corso.clinica.services.VisitaService;

@Controller
@RequestMapping("/visita")
public class VisitaController {

	@Autowired
	private VisitaService visitaService;
	@Autowired
	private AnimaleService animaleService;
	
	@GetMapping("/create/{id}")
	public String create(@PathVariable Long id, Model model) {

		VisitaEntity visitaEntity = new VisitaEntity();
		model.addAttribute("visita", visitaEntity);
		model.addAttribute("animale", animaleService.findById(id));

		return "createVisita";
	}
	
	@PostMapping("/create/{id}")
	public String save(@PathVariable Long id, String data_inizio, String tipo_visita, Model model) {
		
       VisitaEntity visitaEntity = new VisitaEntity();
       
        visitaEntity.setTipo_visita(tipo_visita);
		visitaEntity.setData_inizio(LocalDate.parse(data_inizio, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		visitaEntity.setAnimale(animaleService.findById(id));
		visitaService.save(visitaEntity);
		model.addAttribute("visita", visitaEntity);
		model.addAttribute("animale", animaleService.findById(id));
		
		return "redirect:/animale/"+ id;
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {

		visitaService.delete(id);
		return "redirect:/animale/"+ id;
	}
	
}
