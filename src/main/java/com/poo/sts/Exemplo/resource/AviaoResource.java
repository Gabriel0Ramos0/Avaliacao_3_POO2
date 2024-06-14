package com.poo.sts.Exemplo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poo.sts.Exemplo.model.Aviao;
import com.poo.sts.Exemplo.service.AviaoService;

@RestController
@RequestMapping ("/aviao")
public class AviaoResource {
	
	@Autowired
	AviaoService service;
	
	@GetMapping
	public List<Aviao> listarTodos(){
		return service.listarTodosAvioes();
	}
	
	@GetMapping ("/{id}")
	public Aviao buscarPorCodigo(@PathVariable Integer id){
		return service.buscaPoCodigo(id);
	}
	
	@GetMapping("/nome/{nome}")
	public Aviao buscarPorNome(@PathVariable String nome){
		return service.buscaPorNome(nome);
	}
	
	@PostMapping
	public Aviao cadastra (@RequestBody Aviao a) {
		return service.insereAviao(a);
	}
	
	
}
