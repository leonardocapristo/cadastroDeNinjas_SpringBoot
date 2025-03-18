package com.github.leonardocapristo.cadastroDeNinjas.d_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.leonardocapristo.cadastroDeNinjas.a_entities.Ninja;
import com.github.leonardocapristo.cadastroDeNinjas.c_services.NinjaServices;

@RestController
@RequestMapping("/ninjas")
@CrossOrigin(origins = "http://127.0.0.1:5500")  // Permitir requisições somente de http://127.0.0.1:5500 (Live Server VS Code)
public class NinjaController {
	
	@Autowired
	NinjaServices ninjaServices;
	
	// Endpoint para obter todos os ninjas
	@GetMapping
	public ResponseEntity<List<Ninja>> buscarTodos() {
		List<Ninja> list = ninjaServices.buscarTodos();
		return ResponseEntity.ok().body(list);
	}

	// Endpoint para obter um ninja por ID
	@GetMapping("/{id}")
	public ResponseEntity<Ninja> buscarPorID(@PathVariable Long id) {
		Ninja obj = ninjaServices.buscarPorID(id);
		return ResponseEntity.ok().body(obj);
	}

	// Endpoint separado para adicionar um ninja
	@PostMapping("/add")
	public ResponseEntity<Ninja> salvarNovo(@RequestBody Ninja ninja) {
		Ninja obj = ninjaServices.salvarNovo(ninja);
		return ResponseEntity.ok().body(obj);
	}

	// Endpoint separado para deletar um ninja por ID
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		ninjaServices.deletar(id);
		return ResponseEntity.noContent().build();
	}

	// Endpoint separado para atualizar um ninja por ID
	@PutMapping("/update/{id}")
	public ResponseEntity<Ninja> atualizar(@PathVariable Long id, @RequestBody Ninja ninja) {
		Ninja obj = ninjaServices.atualizar(id, ninja);
		return ResponseEntity.ok().body(obj);
	}
}
