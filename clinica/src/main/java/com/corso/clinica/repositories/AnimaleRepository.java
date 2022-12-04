package com.corso.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corso.clinica.entities.AnimaleEntity;

@Repository
public interface AnimaleRepository extends JpaRepository<AnimaleEntity, Long>{

}
