package com.corso.clinica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corso.clinica.entities.VisitaEntity;
import com.corso.clinica.repositories.VisitaRepository;

@Service
public class VisitaService {
	
	@Autowired
	private VisitaRepository visitaRepository;
	
	public List<VisitaEntity> listaAll() {
		return visitaRepository.findAll();
	}
	
	public void save (VisitaEntity visitaEntity) {
		visitaRepository.save(visitaEntity);
	}
	
	public void delete (Long id) {
		visitaRepository.deleteById(id);
	}

}
