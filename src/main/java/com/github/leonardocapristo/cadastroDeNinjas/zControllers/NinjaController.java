package com.github.leonardocapristo.cadastroDeNinjas.zControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.leonardocapristo.cadastroDeNinjas.entities.Ninja;
import com.github.leonardocapristo.cadastroDeNinjas.services.NinjaServices;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
	
	@Autowired
	NinjaServices ninjaServices;
	
	// Endpoint para obter todos os ninjas
	@GetMapping
	public ResponseEntity<List<Ninja>> findAll() {
		List<Ninja> list = ninjaServices.findAll();
		return ResponseEntity.ok().body(list);
	}

	// Endpoint para obter um ninja por ID
	@GetMapping("/{id}")
	public ResponseEntity<Ninja> findById(@PathVariable Long id) {
		Ninja obj = ninjaServices.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	// Endpoint separado para adicionar um ninja
	@PostMapping("/add")
	public ResponseEntity<Ninja> insert(@RequestBody Ninja ninja) {
		Ninja obj = ninjaServices.save(ninja);
		return ResponseEntity.ok().body(obj);
	}

	// Endpoint separado para deletar um ninja por ID
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		ninjaServices.delete(id);
		return ResponseEntity.noContent().build();
	}

	// Endpoint separado para atualizar um ninja por ID
	@PutMapping("/update/{id}")
	public ResponseEntity<Ninja> update(@PathVariable Long id, @RequestBody Ninja ninja) {
		Ninja obj = ninjaServices.update(id, ninja);
		return ResponseEntity.ok().body(obj);
	}
}
