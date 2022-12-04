package com.corso.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corso.clinica.entities.VisitaEntity;

@Repository
public interface VisitaRepository extends JpaRepository<VisitaEntity, Long>{

}
