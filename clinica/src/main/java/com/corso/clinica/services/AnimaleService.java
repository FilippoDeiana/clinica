package com.corso.clinica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corso.clinica.entities.AnimaleEntity;
import com.corso.clinica.repositories.AnimaleRepository;

@Service
public class AnimaleService {

	@Autowired
	private AnimaleRepository animaleRepository;

	public List<AnimaleEntity> listaAll() {
		return animaleRepository.findAll();
	}

	public AnimaleEntity findById(Long id) {
		return animaleRepository.findById(id).orElse(null);
	}

	public void save(AnimaleEntity animaleEntity) {
		animaleRepository.save(animaleEntity);
	}

	public void update(AnimaleEntity animaleEntity) {

		if (animaleRepository.findById(animaleEntity.getId()).isPresent()) {
			animaleRepository.save(animaleEntity);
		}

	}

	public void delete(Long id) {
		animaleRepository.deleteById(id);
	}

}
