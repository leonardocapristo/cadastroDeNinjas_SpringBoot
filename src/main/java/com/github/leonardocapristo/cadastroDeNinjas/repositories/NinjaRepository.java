package com.github.leonardocapristo.cadastroDeNinjas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.leonardocapristo.cadastroDeNinjas.entities.Ninja;

public interface NinjaRepository extends JpaRepository<Ninja, Long>{
	
	

}
