package com.github.leonardocapristo.cadastroDeNinjas.c_services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.leonardocapristo.cadastroDeNinjas.a_entities.Ninja;
import com.github.leonardocapristo.cadastroDeNinjas.b_repositories.NinjaRepository;

@Service

public class NinjaServices {
	
    @Autowired
    private NinjaRepository ninjaRepository;
	
    public List<Ninja> buscarTodos() {
        return ninjaRepository.findAll();
    }

    public Ninja buscarPorID(Long id) {
        Optional<Ninja> obj = ninjaRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Ninja não encontrado"));
    }

    public Ninja salvarNovo(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }

    public void deletar(Long id) {
    	ninjaRepository.deleteById(id);
    }

    public Ninja atualizar(Long id, Ninja updatedNinja) {
        Ninja ninja = buscarPorID(id);
        ninja.setName(updatedNinja.getName());
        ninja.setIdade(updatedNinja.getIdade());
        return ninjaRepository.save(ninja);
    }

}
