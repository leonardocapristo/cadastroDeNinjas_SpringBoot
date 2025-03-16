package com.github.leonardocapristo.cadastroDeNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.leonardocapristo.cadastroDeNinjas.entities.Ninja;
import com.github.leonardocapristo.cadastroDeNinjas.repositories.NinjaRepository;

@Service

public class NinjaServices {
	
    @Autowired
    private NinjaRepository ninjaRepository;
	
    public List<Ninja> findAll() {
        return ninjaRepository.findAll();
    }

    public Ninja findById(Long id) {
        Optional<Ninja> obj = ninjaRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Ninja não encontrado"));
    }

    public Ninja save(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }

    public void delete(Long id) {
    	ninjaRepository.deleteById(id);
    }

    public Ninja update(Long id, Ninja updatedNinja) {
        Ninja ninja = findById(id);
        ninja.setName(updatedNinja.getName());
        ninja.setIdade(updatedNinja.getIdade());
        return ninjaRepository.save(ninja);
    }

}
