package com.poo.Prova3.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poo.Prova3.model.Passageiro;
import com.poo.Prova3.service.PassageiroService;

@RestController
@RequestMapping ("/passageiro")
public class PassageiroResource {
	
	@Autowired
	PassageiroService service;
	
	@GetMapping
	public List<Passageiro> listaTodos(){
		return service.listaTodosPassageiros();
	}
	
	@GetMapping("/{id}")
	public Passageiro buscarPorCodigo(@PathVariable Integer id){
		return service.buscaPoCodigo(id);
	}
	
	@PostMapping
	public Passageiro cadastra(@RequestBody Passageiro p) {
		return service.inserePassageiro(p);
	}	
	
}