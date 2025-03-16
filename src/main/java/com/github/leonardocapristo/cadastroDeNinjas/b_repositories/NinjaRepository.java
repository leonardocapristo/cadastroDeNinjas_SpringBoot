package com.github.leonardocapristo.cadastroDeNinjas.b_repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.leonardocapristo.cadastroDeNinjas.a_entities.Ninja;

public interface NinjaRepository extends JpaRepository<Ninja, Long>{
	
	

}
